public class EmailService {

    private final ContactListService contactListService;

    @Inject
    public EmailService(ContactListService contactListService){
        this.contactListService = contactListService;
        /*
        The above means the CLS will be injected into EmailService
        This object will be created by default as singleton.
        This means that if we inject in multiple classes,
        it will reuse the same instance.
        */
            //this.contactListService = new ContactListService();
            //Intantiating first instance of ContatcListService
        }
    void sendEmail(){
        contactListService.getContacts().forEach(() -> ContactListService::send);
        }
}

public class MailChimpEmailService {

    private final ContactListService contactListService;

    public MailChimpEmailService(ContactListService contactListService){
        this.contactListService = contactListService;
        //this.contactListService = new ContactListService();
        /*Intantiating another instance of ContatcListService
        Creating a lot of objects like this will be stored in
        a heap and can be garbage collected or be a singleton object
        And is also very difficult to test*/
    }

    void sendEmail(){
        contactListService.getContacts().forEach(() -> ContactListService::send);
    }
}

@Service //Tells spring to instantiate the object that we injected
public class ContactListService {
    public ContactListService() {
    }

    public List<Contacts> getContacts() {
    // ... goes to db to get some data
       return ImmutableList.copyOf();
    }

    void send(Contact contact) {
        //implement how to send email
    }
}