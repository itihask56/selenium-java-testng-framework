import com.fasterxml.jackson.annotation.JsonProperty;

public class Answers {

    private String Region;

    @JsonProperty("Services requirements")
    private String servicesRequirements;

    @JsonProperty("Carer Type")
    private String carerType;

    @JsonProperty("Service City")
    private String serviceCity;

    public Answers(
            String region,
            String servicesRequirements,
            String carerType,
            String serviceCity
    ) {
        this.Region = region;
        this.servicesRequirements = servicesRequirements;
        this.carerType = carerType;
        this.serviceCity = serviceCity;
    }

    public String getRegion() {
        return Region;
    }

    public String getServicesRequirements() {
        return servicesRequirements;
    }

    public String getCarerType() {
        return carerType;
    }

    public String getServiceCity() {
        return serviceCity;
    }
}