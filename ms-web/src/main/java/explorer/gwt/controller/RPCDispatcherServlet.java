package explorer.gwt.controller;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RPCDispatcherServlet extends RemoteServiceServlet {

    @Override
    public String processCall(String payload) throws SerializationException {
        payload.toString();
        return null;
    }
}
