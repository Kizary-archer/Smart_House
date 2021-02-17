package app.constants;

import lombok.experimental.UtilityClass;

/**
 * Константы сообщений об ошибках.
 */
@UtilityClass
public class MessageConstants {

    /**
     * Сообщение об отсутствии пользователя с данным id
     */
    public static final String USER_ID_NOT_FOUND = "user.id.notFound";

    /**
     * Сообщение об отсутствии пользователя с данным логином
     */
    public static final String USER_LOGIN_NOT_FOUND = "user.login.notFound";

    /**
     * Сообщение об отсутствии логина пользователя при регистрации
     */
    public static final String USERS_NOT_FOUND = "user.notFound";

}
