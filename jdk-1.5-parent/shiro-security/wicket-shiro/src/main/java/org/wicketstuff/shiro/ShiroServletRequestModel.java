package org.wicketstuff.shiro;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.cycle.RequestCycle;

public class ShiroServletRequestModel extends
		LoadableDetachableModel<HttpServletRequest> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected HttpServletRequest load() {
		Request request = RequestCycle.get().getRequest();
		return (HttpServletRequest) request.getContainerRequest();
	}
}
