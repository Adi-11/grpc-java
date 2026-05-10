package bankai.sec03;

import bankai.models.sec03.Credential;
import bankai.models.sec03.Email;
import bankai.models.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CredDemo {
    private static final Logger log = LoggerFactory.getLogger(CredDemo.class);

    public static void main() {
        Email email = Email.newBuilder().setAddress("adi@gmail.com").setPassword("admin").build();
        Phone phone = Phone.newBuilder().setNumber(2345678921L).setCode(1234).build();

        Credential credentialEmail = Credential.newBuilder().setEmail(email).build();
        login(credentialEmail);
        Credential credentialPhone = Credential.newBuilder().setPhone(phone).build();
        login(credentialPhone);
        Credential credentialError = Credential.newBuilder().build();
        login(credentialError);
    }

    private static void login(Credential credential) {
        switch (credential.getLoginTypeCase()) {
            case EMAIL -> log.info("email {}", credential.getEmail());
            case PHONE -> log.info("phone {}", credential.getPhone());
            case LOGINTYPE_NOT_SET -> log.error("error login type not found");
        }
    }
}
