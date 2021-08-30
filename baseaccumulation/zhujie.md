@Slf4j~~~~
@Component
@JobHander("aiCollectionTaskCallJob")
public class AiCollectionTaskCallJob extends IJobHandler

            compile(group: 'com.xuxueli', name: 'xxl-job-core', version: '1.8.2')

@Autowired
@Qualifier("aiMessageService")
private MessageService messageService;

在使用@Autowire自动注入的时候，
加上@Qualifier(“test”)可以指定注入哪个对象；