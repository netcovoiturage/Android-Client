package ru.ododo.logic;

//класс с константами
public class Settings {
	public final static String VK_AUTH_URL="https://oauth.vk.com/authorize?";
	//идентификатор приложения
	public final static String VK_CLINT_ID="client_id=3934029&";
	//редирект на сайт, для standalone приложений редирект равен заглушки
	public final static String VK_REDIRECT_URL="edirect_uri=https://oauth.vk.com/blank.htm&";
	//настройка доступа приложения
	public final static String VK_SCOPE="scope=offline&";
	//указывает тип отображения страницы 
	public final static String VK_DISPLAY="display=mobile&";
	//Тип ответа, который Вы хотите получить
	public final static String VK_RESPONSE_TYPE="response_type = token";
}
