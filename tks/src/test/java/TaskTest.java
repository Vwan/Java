/**
 * Created by wanjia on 2016/8/11.
 */
public class TaskTest {
  /*  TaskService taskService ;
    TaskStatusService statusService;
    TaskRepo taskRepo;
    TaskStatusRepo statusRepo;

    @Before
    public void setup(){
        taskRepo=new TaskRepo();
        taskService = new TaskService(taskRepo);
        statusRepo = new TaskStatusRepo();
        statusService = new TaskStatusService(statusRepo);
    }

    @Test
    public void testCreateTask(){
        TaskStatus status = new TaskStatus ("NEW","NEW Status1");
        statusService.save();
      //  statusService.commit();
     //   statusService = new TaskStatusService(statusRepo);
         status = (TaskStatus)statusService.findById(TaskStatus.class,1l);
        System.out.println("status is " + status);
        System.out.println(status.getId());
        Task task = new Task("t11","td11",status);
        taskService.save();
        System.out.println(taskService.findById(Task.class,1l));
    }

    @After
    public void tearndown(){
        taskService.commit();
    }
    */
}
