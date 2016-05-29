package client.navigation_panel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import explorer.NavigationTreeNode;
import explorer.NavigationTreeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
public class NavigationPanelController {

    @Resource
    private NavigationTreeService navigationTreeService;

    @RequestMapping(value = "navigation_menu/navigation_tree.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getNavigationMenu(){
        List<NavigationTreeNode> navigationMenuData = navigationTreeService.getNavigationTreeNodes(NavigationTreeNode.NodeType.NODE);
        Gson jsonFromNavigationTreeNode = new GsonBuilder()
                .registerTypeAdapter(NavigationTreeNode.class, new NavigationTreeNodeTypeAdapter())
                .create();
      return jsonFromNavigationTreeNode.toJson(navigationMenuData);

    }

    @RequestMapping(value = "/limits_list", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getLimitsListMock(){
        return "{ \"gridData\" : \"Limit Grid Data retrieved succesfully\" }";
    }

    @RequestMapping(value = "/limits_upload", method = RequestMethod.GET)
    @ResponseBody
    public String getLimitsUploadMock(){
        return "{}";
    }

    @RequestMapping(value = "/exposures_list", method = RequestMethod.GET)
    @ResponseBody
    public String getExposuresListMock(){
        return "{}";
    }

    @RequestMapping(value = "/exposures_upload", method = RequestMethod.GET)
    @ResponseBody
    public String getExposuresUploadMock(){
        return "{}";
    }

    @RequestMapping(value = "/breaches_list", method = RequestMethod.GET)
    @ResponseBody
    public String getBreachesListMock(){
        return "{}";
    }

    private static class NavigationTreeNodeTypeAdapter extends TypeAdapter<NavigationTreeNode> {

        private static final String PARENT_MENU_NODE = "parent";
        public static final String CHILDREN_MENU_LEAF = "children";
        public static final String CHILD_NAME = "childName";
        public static final String CHILD_URL_PATTERN = "urlPattern";

        @Override
        public void write(JsonWriter jsonWriter, NavigationTreeNode navigationTreeNode) throws IOException {
            jsonWriter.beginObject();
            jsonWriter.name(PARENT_MENU_NODE).value(navigationTreeNode.getNodeName());
            JsonWriter childrenArrayJsonWriter = jsonWriter.name(CHILDREN_MENU_LEAF).beginArray();
            for (NavigationTreeNode childNode : navigationTreeNode.getChildren()) {
                childrenArrayJsonWriter.beginObject();
                childrenArrayJsonWriter.name(CHILD_NAME).value(childNode.getNodeName());
                childrenArrayJsonWriter.name(CHILD_URL_PATTERN).value(childNode.getUrlAddress());
                childrenArrayJsonWriter.endObject();
            }
            childrenArrayJsonWriter.endArray();
            jsonWriter.endObject();
        }

        @Override
        public NavigationTreeNode read(JsonReader jsonReader) throws IOException {
            return null;
        }
    }

}
