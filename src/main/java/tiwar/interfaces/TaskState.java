package tiwar.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tiwar.TiwarTasks;

import java.time.LocalDateTime;

public class TaskState {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskState.class);
    private boolean shouldExecute;
    private LocalDateTime lastExecuted;
    private LocalDateTime nextExecution;

    public TaskState() {
        shouldExecute = true;
        lastExecuted = LocalDateTime.now();
        nextExecution = LocalDateTime.now();
    }

    public boolean isShouldExecute() {
        LOGGER.info("Should execute Flag:{} Time:{}",
                this.shouldExecute, nextExecution.isBefore(LocalDateTime.now()));
        return shouldExecute && nextExecution.isBefore(LocalDateTime.now());
    }

    public void setShouldExecute(boolean shouldExecute) {
        LOGGER.info("Setting Should Execute {}",shouldExecute);
        this.shouldExecute = shouldExecute;
    }

    public LocalDateTime getLastExecuted() {
        return lastExecuted;
    }

    public void setLastExecuted(LocalDateTime lastExecuted) {
        LOGGER.info("Setting Last Execution Time {}", lastExecuted);
        this.lastExecuted = lastExecuted;
    }

    public LocalDateTime getNextExecution() {
        return nextExecution;
    }

    public void setNextExecution(LocalDateTime nextExecution) {
        LOGGER.info("Setting Next Execution Time {}", nextExecution);
        this.nextExecution = nextExecution;
    }
}
