package servlets_package;

import crud_package.FileCrud;
import crud_package.Lab2CrudInterface;
import mock.Lab2CrudMock;

public class ServletConfig implements ServletConfigInterface {

	Lab2CrudInterface l2ci;
	
	public ServletConfig() {
		
		this.l2ci = new FileCrud();
		
	}

	public void setL2ci(Lab2CrudInterface l2ci) {
		this.l2ci = l2ci;
	}



	@Override
	public Lab2CrudInterface getCrud() {
		// TODO Auto-generated method stub
		return l2ci;
	}

}
