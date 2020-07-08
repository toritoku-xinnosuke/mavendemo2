//import java.util.Map;
//
//public class JobEndpoint extends AbstractEndPoint<Map<String, Object>> implements Job
//{
//    /**
//     *
//     *
//     * 引用配置文件中的bean
//     *
//     */
//    @Override
//    public IBEExecutor getBEExecutor()
//    {
//        return (IBEExecutor) SpringContainer.getApplicationContext().getBean("springThreadPoolExecutor");
//    }
//    /**
//     * 执行
//     *
//     *
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public IMessageConverter<Map<String, Object>> getMessageConverter()
//    {
//        // return ScheduleManager.getInstance().getMessageConverter();
//        return (IMessageConverter<Map<String, Object>>) SpringContainer.getApplicationContext()
//                .getBean("mapMsgConverter");
//    }
//    /**
//     * 上下文赋值执行
//     *
//     * @param msg
//     *
//     */
//    @Override
//    protected FlowContext createContext(Map<String, Object> msg) throws BusinessException
//    {
//        FlowContext context = new FlowContext();
//        context.setMessageConverter(this.getMessageConverter());
//        context.setExecutor(this.getBEExecutor());
//        context.setSqlExecutor(this.getBEExecutor().getSqlExecutor());
//        if (msg != null) {
//            context.setTraceId((String) msg.get("msg_id"));
//            context.putAll(msg);
//            context.setReq(msg);
//        }
//        return context;
//    }
//
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
//    {
//    }
//}
