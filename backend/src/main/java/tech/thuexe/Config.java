package tech.thuexe;

public class Config {
    public enum ROLE {
        USER("ROLE_USER"), SALE("ROLE_SALE"), ROOT("ROLE_ROOT");
        private final String name;

        ROLE(String s) {
            name = s;
        }
    }
    public enum ENV {
        SECRET((Math.random() * 600) + "this is secret code");
        private final String name;
        ENV(String s) {
            name = s;
        }
    }
}
