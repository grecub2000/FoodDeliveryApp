package service;

public class AdminService {

    private static final AdminService instance = new AdminService();

    private AdminService() {

    }

    public static AdminService getInstance(){
        return instance;
    }

    private DefaultService defaultService = DefaultService.getInstance();



}
