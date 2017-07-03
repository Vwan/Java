package MockitTo;

public class TaskServiceMockTest {
  /*  @InjectMocks
    private TaskService taskService;
    @Mock
    private TaskRepo taskRepo;
    @Mock
    private TaskStatus status;
    @Mock
    private TaskStatusService statusService;
    @ClassRule
    static public StatusRule sr = new StatusRule();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        taskService.setTaskRepo(taskRepo);
        status = (TaskStatus)statusService.findById(TaskStatus.class,1l);
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
