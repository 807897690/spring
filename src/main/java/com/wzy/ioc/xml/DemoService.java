package com.wzy.ioc.xml;

public class DemoService {

    private static ClientService clientService = new ClientService();

    private static AccountService accountService = new AccountService();

    public ClientService newClientServiceInstance() {
        return clientService;
    }

    public AccountService newAccountServiceInstance() {
        return accountService;
    }

}
