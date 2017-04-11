import org.apache.log4j.Logger;

public class Micro2
{
    private static final int REPS = 1000000;
    private static final String PART1 = "for a real test, make this big";
    private static final String PART2 = "so that we can see GC effects";
    private static final String REGEX = "XXX";
    private static final String REPL = " -- ";
    private static final String TEMPLATE = PART1 + REGEX + PART2;

    private enum CodeType { concat, replace };
    
    private static Logger log = Logger.getLogger(Micro2.class);

    public static void main(String[] argv)
    throws Exception
    {
    	long threadId = Thread.currentThread().getId();
    	
        for (CodeType run : CodeType.values())
        {
            long start = System.currentTimeMillis();
            switch (run)
            {
                case concat :
                    executeConcat(PART1, PART2, REPL);
                    break;
                case replace :
                    executeReplace(TEMPLATE, REGEX, REPL);
                    break;
                default :
                    // do nothing
            }
            long elapsed = System.currentTimeMillis() - start;

            log.info("ThreadId = " + threadId + ", " + run + ": elapsed time = " + elapsed + "ms ("
                                   + (elapsed * 1000.0) / REPS + "microseconds per execution)");
        }
    }

    private static void executeReplace(String template, String regex, String repl)
    {
        for (int ii = 0 ; ii < REPS ; ii++)
        {
            String s = template.replaceAll(regex, repl);
        }
    }

    private static void executeConcat(String part1, String part2, String repl)
    {
        for (int ii = 0 ; ii < REPS ; ii++)
        {
            String s = part1 + repl + part2;
        }
    }
}