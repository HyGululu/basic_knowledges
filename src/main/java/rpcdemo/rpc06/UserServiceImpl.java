package rpcdemo.rpc06;

import rpcdemo.rpc1.IUserService;
import rpcdemo.rpc1.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id, "ghy");
    }
}
