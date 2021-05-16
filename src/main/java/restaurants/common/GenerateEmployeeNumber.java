package restaurants.common;

import restaurants.interceptors.LoggedInvocation;
import restaurants.services.EmployeeNumberGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class GenerateEmployeeNumber implements Serializable {
    @Inject
    EmployeeNumberGenerator employeeNumberGenerator;

    private Future<Integer> employeeNumberGenerationTask = null;

    @LoggedInvocation
    public String generateNewEmployeeNumber() throws InterruptedException {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        employeeNumberGenerationTask = employeeNumberGenerator.generateEmployeeNumber();
        return  "/employeeEdit.xhtml?faces-redirect=true&employeeId=" + requestParameters.get("employeeId");
    }

    public boolean isEmployeeGenerationRunning() {
        return employeeNumberGenerationTask != null && !employeeNumberGenerationTask.isDone();
    }

    public String getEmployeeGenerationStatus() throws ExecutionException, InterruptedException {
        if (employeeNumberGenerationTask == null) {
            return null;
        } else if (isEmployeeGenerationRunning()) {
            return "Employee generation in progress";
        }
        return "Suggested employee number: " + employeeNumberGenerationTask.get();
    }
}
