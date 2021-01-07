package com.jarrm5.util;

import com.jarrm5.exception.AdminAccountException;
import com.jarrm5.exception.AppGenericException.ErrorReason;
import com.jarrm5.model.AdminAccount;
import com.jarrm5.model.UserAccount;

public class AdminService {

	public static void banUser(AdminAccount admin, UserAccount user) throws AdminAccountException{
		if(user.isBanned()) {
			throw new AdminAccountException(ErrorReason.USER_ACCOUNT_BANNED,admin);
		}
		else {
			user.setBanned(true);
			admin.setNumberOfBans(admin.getNumberOfBans() + 1);
		}
	}
	public static void unbanUser(AdminAccount admin, UserAccount user) throws AdminAccountException {
		if(!user.isBanned()) throw new AdminAccountException(ErrorReason.USER_ACCOUNT_UNBANNED,admin);
		else user.setBanned(false);
	}
}
