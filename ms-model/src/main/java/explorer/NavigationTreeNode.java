package explorer;

import parentEntity.ParentId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NAVIGATION_TREE_NODE")
public class NavigationTreeNode extends ParentId {

    @Column(name = "NODE_NAME")
    private String nodeName;

    @Column(name = "NODE_TYPE")
    @Enumerated(EnumType.STRING)
    private NodeType nodeType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID")
    private NavigationTreeNode parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<NavigationTreeNode> children;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public void setParent(NavigationTreeNode parent) {
        this.parent = parent;
    }

    public NavigationTreeNode getParent() {
        return parent;
    }

    public void setChildren(List<NavigationTreeNode> children) {
        this.children = children;
    }

    public List<NavigationTreeNode> getChildren() {
        return children;
    }

    public enum NodeType {
        ROOT,
        NODE,
        LEAF;

        public String getName() {
            return this.name();
        }
    }

}
