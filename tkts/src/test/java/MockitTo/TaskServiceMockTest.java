package MockitTo;

public class TaskServiceMockTest {
  /*  @InjectMocks
    private TaskService taskService;
    @Mock
    private TaskRepo taskRepo;
    @Mock
    private Status status;
    @Mock
    private StatusService statusService;
    @ClassRule
    static public StatusRule sr = new StatusRule();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        taskService.setTaskRepo(taskRepo);
        status = (Status)statusService.findById(Status.class,1l);
        System.out.println(status);
    }

    @Test
    public void testCreate() throws Exception {
        Task task = new Task("name","desc",status);
        when(taskRepo.save(task)).thenReturn( task);
        Task newtask = (Task)taskService.save(task);
        verify(taskRepo,times(1)).save(task);
        assertThat(task.getDescription(), is("desc"));
    }
    @After
    public void after(){
        taskService.commit();
    }
*/
}
