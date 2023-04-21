package simpleController11.api.view.delegator;

import simpleController11.ViewContainer;

public interface Delegator {
	
	public void inject(ViewContainer viewContainer);
	public void clean(ViewContainer viewContainer);

}