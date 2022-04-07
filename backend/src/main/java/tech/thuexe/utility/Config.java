package tech.thuexe.utility;

public class Config {
    public enum ROLE {
        USER("ROLE_USER"),
        SALE("ROLE_SALE"),
        ROOT("ROLE_ROOT");
        private String value;
        ROLE(String s) {
            this.value = s;
        }
        public String getValue(){
            return  this.value;
        }
    }
    public enum CONFIG {
        SECRET((Math.random()*9999)+" This is secret key");
        private String value;
        CONFIG(String s) {
            this.value = s;
        }
        public String getValue(){
            return  this.value;
        }
    }
}
