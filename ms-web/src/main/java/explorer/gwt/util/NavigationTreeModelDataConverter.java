package explorer.gwt.util;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.store.TreeStore;

import static explorer.NavigationTreeNode.NodeType.LEAF;
import static explorer.NavigationTreeNode.NodeType.NODE;

import com.extjs.gxt.ui.client.store.TreeStoreModel;
import explorer.NavigationTreeNode;


import static util.NavigationTreeNodeProperties.ID;
import static util.NavigationTreeNodeProperties.NODE_NAME;
import static util.NavigationTreeNodeProperties.NODE_TYPE;
import static util.NavigationTreeNodeProperties.PARENT;

import java.util.ArrayList;
import java.util.List;

public final class NavigationTreeModelDataConverter {

    public static List<BaseTreeModel> convertToBaseTreeModelList(List<NavigationTreeNode> treeNodeList) {
        List<BaseTreeModel> resultList = new ArrayList<BaseTreeModel>();
        for (NavigationTreeNode treeNode : treeNodeList) {
            if (treeNode.getNodeType().equals(NODE)) {
                TreeModel parentNode = convertToTreeModel(treeNode);
                BaseTreeModel treeModel = new BaseTreeModel(parentNode);
                for (NavigationTreeNode treeLeaf : treeNode.getChildren()) {
                    treeModel.add(convertNodeToModelData(treeLeaf));
                }
                resultList.add(treeModel);
            }
        }
        return resultList;
    }

    private static ModelData convertNodeToModelData(NavigationTreeNode treeLeaf) {
        ModelData modelData = new BaseModelData();
        modelData.set(ID.getValue(), treeLeaf.getId());
        modelData.set(NODE_NAME.getValue(), treeLeaf.getNodeName());
        modelData.set(NODE_TYPE.getValue(), treeLeaf.getNodeType().getName());
        modelData.set(PARENT.getValue(), treeLeaf.getParent().getId());
        return modelData;
    }

    private static TreeModel convertToTreeModel(NavigationTreeNode parentNode) {
        TreeModel parentTreeModel = new BaseTreeModel();
        parentTreeModel.set(ID.getValue(), parentNode.getId());
        parentTreeModel.set(NODE_NAME.getValue(), parentNode.getNodeName());
        parentTreeModel.set(NODE_TYPE.getValue(), parentNode.getNodeType().getName());
        parentTreeModel.set(PARENT.getValue(), parentNode.getParent().getId());
        return parentTreeModel;
    }

}
