package servlets_package;

import crud_package.Lab2CrudInterface;
import mock.Lab2CrudMock;

public class ServletConfig implements ServletConfigInterface {

	@Override
	public Lab2CrudInterface getCrud() {
		// TODO Auto-generated method stub
		return new Lab2CrudMock();
	}

}
