package MockitTo;

public class TaskServiceImplTest {
  /*  @InjectMocks
    private TaskService taskService;
    @Mock
    private TaskRepo taskRepo;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        taskService.setTaskRepo(taskRepo);
    }

    @Test
    public void testCreate() throws Exception {
        Task task = new Task("name","desc",new TaskStatus("status","desc"));
        when(taskRepo.save(task)).thenReturn( task);
        Task newtask = (Task)taskService.save(taskRepo,task);
        verify(taskRepo,times(1)).save(task);
        assertThat(task.getDescription(), is("name"));

    }
*/
}
