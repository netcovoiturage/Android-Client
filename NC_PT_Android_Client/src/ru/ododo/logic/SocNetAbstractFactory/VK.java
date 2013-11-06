package ru.ododo.logic.SocNetAbstractFactory;

public class VK extends AbstractFactory{

	@Override
	public AbstractProductSocNetConnect create() {
		// TODO Auto-generated method stub
		return new VKConnect();
	}

}
