package tiwar.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.pages.TiwarArenaPage;

public abstract class TiwarBasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(TiwarArenaPage.class);
    protected TaskState TASK_STATE = new TaskState();

    protected abstract String url();

    public abstract void runTasks();

    public void run() {
        LOGGER.info("Inside {}", this);
        if (TASK_STATE.isShouldExecute()) {
            this.runTasks();
        }
    }
}
