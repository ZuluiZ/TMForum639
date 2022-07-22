package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AttachmentRefOrValue;
import io.swagger.model.Characteristic;
import io.swagger.model.Feature;
import io.swagger.model.Note;
import io.swagger.model.RelatedParty;
import io.swagger.model.RelatedPlaceRefOrValue;
import io.swagger.model.ResourceAdministrativeStateType;
import io.swagger.model.ResourceOperationalStateType;
import io.swagger.model.ResourceRelationship;
import io.swagger.model.ResourceSpecificationRef;
import io.swagger.model.ResourceStatusType;
import io.swagger.model.ResourceUsageStateType;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Resource is an abstract entity that describes the common set of attributes shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory. Skipped properties: id,href
 */
@ApiModel(description = "Resource is an abstract entity that describes the common set of attributes shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T01:38:50.932Z")


public class ResourceUpdate   {
  @JsonProperty("category")
  private String category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("endOperatingDate")
  private OffsetDateTime endOperatingDate = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("resourceVersion")
  private String resourceVersion = null;

  @JsonProperty("startOperatingDate")
  private OffsetDateTime startOperatingDate = null;

  @JsonProperty("activationFeature")
  @Valid
  private List<Feature> activationFeature = null;

  @JsonProperty("administrativeState")
  private ResourceAdministrativeStateType administrativeState = null;

  @JsonProperty("attachment")
  @Valid
  private List<AttachmentRefOrValue> attachment = null;

  @JsonProperty("note")
  @Valid
  private List<Note> note = null;

  @JsonProperty("operationalState")
  private ResourceOperationalStateType operationalState = null;

  @JsonProperty("place")
  private RelatedPlaceRefOrValue place = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("resourceCharacteristic")
  @Valid
  private List<Characteristic> resourceCharacteristic = null;

  @JsonProperty("resourceRelationship")
  @Valid
  private List<ResourceRelationship> resourceRelationship = null;

  @JsonProperty("resourceSpecification")
  private ResourceSpecificationRef resourceSpecification = null;

  @JsonProperty("resourceStatus")
  private ResourceStatusType resourceStatus = null;

  @JsonProperty("usageState")
  private ResourceUsageStateType usageState = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ResourceUpdate category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Category of the concrete resource. e.g Gold, Silver for MSISDN concrete resource
   * @return category
  **/
  @ApiModelProperty(value = "Category of the concrete resource. e.g Gold, Silver for MSISDN concrete resource")


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ResourceUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * free-text description of the resource
   * @return description
  **/
  @ApiModelProperty(value = "free-text description of the resource")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ResourceUpdate endOperatingDate(OffsetDateTime endOperatingDate) {
    this.endOperatingDate = endOperatingDate;
    return this;
  }

  /**
   * A date time( DateTime). The date till the resource is operating
   * @return endOperatingDate
  **/
  @ApiModelProperty(value = "A date time( DateTime). The date till the resource is operating")

  @Valid

  public OffsetDateTime getEndOperatingDate() {
    return endOperatingDate;
  }

  public void setEndOperatingDate(OffsetDateTime endOperatingDate) {
    this.endOperatingDate = endOperatingDate;
  }

  public ResourceUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A string used to give a name to the resource
   * @return name
  **/
  @ApiModelProperty(value = "A string used to give a name to the resource")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceUpdate resourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
    return this;
  }

  /**
   * A field that identifies the specific version of an instance of a resource.
   * @return resourceVersion
  **/
  @ApiModelProperty(value = "A field that identifies the specific version of an instance of a resource.")


  public String getResourceVersion() {
    return resourceVersion;
  }

  public void setResourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
  }

  public ResourceUpdate startOperatingDate(OffsetDateTime startOperatingDate) {
    this.startOperatingDate = startOperatingDate;
    return this;
  }

  /**
   * A date time( DateTime). The date from which the resource is operating
   * @return startOperatingDate
  **/
  @ApiModelProperty(value = "A date time( DateTime). The date from which the resource is operating")

  @Valid

  public OffsetDateTime getStartOperatingDate() {
    return startOperatingDate;
  }

  public void setStartOperatingDate(OffsetDateTime startOperatingDate) {
    this.startOperatingDate = startOperatingDate;
  }

  public ResourceUpdate activationFeature(List<Feature> activationFeature) {
    this.activationFeature = activationFeature;
    return this;
  }

  public ResourceUpdate addActivationFeatureItem(Feature activationFeatureItem) {
    if (this.activationFeature == null) {
      this.activationFeature = new ArrayList<Feature>();
    }
    this.activationFeature.add(activationFeatureItem);
    return this;
  }

  /**
   * Configuration features
   * @return activationFeature
  **/
  @ApiModelProperty(value = "Configuration features")

  @Valid

  public List<Feature> getActivationFeature() {
    return activationFeature;
  }

  public void setActivationFeature(List<Feature> activationFeature) {
    this.activationFeature = activationFeature;
  }

  public ResourceUpdate administrativeState(ResourceAdministrativeStateType administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.
   * @return administrativeState
  **/
  @ApiModelProperty(value = "Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.")

  @Valid

  public ResourceAdministrativeStateType getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(ResourceAdministrativeStateType administrativeState) {
    this.administrativeState = administrativeState;
  }

  public ResourceUpdate attachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ResourceUpdate addAttachmentItem(AttachmentRefOrValue attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<AttachmentRefOrValue>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AttachmentRefOrValue> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
  }

  public ResourceUpdate note(List<Note> note) {
    this.note = note;
    return this;
  }

  public ResourceUpdate addNoteItem(Note noteItem) {
    if (this.note == null) {
      this.note = new ArrayList<Note>();
    }
    this.note.add(noteItem);
    return this;
  }

  /**
   * Get note
   * @return note
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Note> getNote() {
    return note;
  }

  public void setNote(List<Note> note) {
    this.note = note;
  }

  public ResourceUpdate operationalState(ResourceOperationalStateType operationalState) {
    this.operationalState = operationalState;
    return this;
  }

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.
   * @return operationalState
  **/
  @ApiModelProperty(value = "Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.")

  @Valid

  public ResourceOperationalStateType getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(ResourceOperationalStateType operationalState) {
    this.operationalState = operationalState;
  }

  public ResourceUpdate place(RelatedPlaceRefOrValue place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RelatedPlaceRefOrValue getPlace() {
    return place;
  }

  public void setPlace(RelatedPlaceRefOrValue place) {
    this.place = place;
  }

  public ResourceUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<RelatedParty>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ResourceUpdate resourceCharacteristic(List<Characteristic> resourceCharacteristic) {
    this.resourceCharacteristic = resourceCharacteristic;
    return this;
  }

  public ResourceUpdate addResourceCharacteristicItem(Characteristic resourceCharacteristicItem) {
    if (this.resourceCharacteristic == null) {
      this.resourceCharacteristic = new ArrayList<Characteristic>();
    }
    this.resourceCharacteristic.add(resourceCharacteristicItem);
    return this;
  }

  /**
   * Get resourceCharacteristic
   * @return resourceCharacteristic
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Characteristic> getResourceCharacteristic() {
    return resourceCharacteristic;
  }

  public void setResourceCharacteristic(List<Characteristic> resourceCharacteristic) {
    this.resourceCharacteristic = resourceCharacteristic;
  }

  public ResourceUpdate resourceRelationship(List<ResourceRelationship> resourceRelationship) {
    this.resourceRelationship = resourceRelationship;
    return this;
  }

  public ResourceUpdate addResourceRelationshipItem(ResourceRelationship resourceRelationshipItem) {
    if (this.resourceRelationship == null) {
      this.resourceRelationship = new ArrayList<ResourceRelationship>();
    }
    this.resourceRelationship.add(resourceRelationshipItem);
    return this;
  }

  /**
   * Get resourceRelationship
   * @return resourceRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceRelationship> getResourceRelationship() {
    return resourceRelationship;
  }

  public void setResourceRelationship(List<ResourceRelationship> resourceRelationship) {
    this.resourceRelationship = resourceRelationship;
  }

  public ResourceUpdate resourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  /**
   * Get resourceSpecification
   * @return resourceSpecification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ResourceSpecificationRef getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ResourceUpdate resourceStatus(ResourceStatusType resourceStatus) {
    this.resourceStatus = resourceStatus;
    return this;
  }

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.
   * @return resourceStatus
  **/
  @ApiModelProperty(value = "Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.")

  @Valid

  public ResourceStatusType getResourceStatus() {
    return resourceStatus;
  }

  public void setResourceStatus(ResourceStatusType resourceStatus) {
    this.resourceStatus = resourceStatus;
  }

  public ResourceUpdate usageState(ResourceUsageStateType usageState) {
    this.usageState = usageState;
    return this;
  }

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.
   * @return usageState
  **/
  @ApiModelProperty(value = "Tracks the lifecycle status of the resource, such as planning, installing, opereating, retiring and so on.")

  @Valid

  public ResourceUsageStateType getUsageState() {
    return usageState;
  }

  public void setUsageState(ResourceUsageStateType usageState) {
    this.usageState = usageState;
  }

  public ResourceUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ResourceUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class Extensible name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class Extensible name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceUpdate resourceUpdate = (ResourceUpdate) o;
    return Objects.equals(this.category, resourceUpdate.category) &&
        Objects.equals(this.description, resourceUpdate.description) &&
        Objects.equals(this.endOperatingDate, resourceUpdate.endOperatingDate) &&
        Objects.equals(this.name, resourceUpdate.name) &&
        Objects.equals(this.resourceVersion, resourceUpdate.resourceVersion) &&
        Objects.equals(this.startOperatingDate, resourceUpdate.startOperatingDate) &&
        Objects.equals(this.activationFeature, resourceUpdate.activationFeature) &&
        Objects.equals(this.administrativeState, resourceUpdate.administrativeState) &&
        Objects.equals(this.attachment, resourceUpdate.attachment) &&
        Objects.equals(this.note, resourceUpdate.note) &&
        Objects.equals(this.operationalState, resourceUpdate.operationalState) &&
        Objects.equals(this.place, resourceUpdate.place) &&
        Objects.equals(this.relatedParty, resourceUpdate.relatedParty) &&
        Objects.equals(this.resourceCharacteristic, resourceUpdate.resourceCharacteristic) &&
        Objects.equals(this.resourceRelationship, resourceUpdate.resourceRelationship) &&
        Objects.equals(this.resourceSpecification, resourceUpdate.resourceSpecification) &&
        Objects.equals(this.resourceStatus, resourceUpdate.resourceStatus) &&
        Objects.equals(this.usageState, resourceUpdate.usageState) &&
        Objects.equals(this.baseType, resourceUpdate.baseType) &&
        Objects.equals(this.schemaLocation, resourceUpdate.schemaLocation) &&
        Objects.equals(this.type, resourceUpdate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, endOperatingDate, name, resourceVersion, startOperatingDate, activationFeature, administrativeState, attachment, note, operationalState, place, relatedParty, resourceCharacteristic, resourceRelationship, resourceSpecification, resourceStatus, usageState, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceUpdate {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endOperatingDate: ").append(toIndentedString(endOperatingDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceVersion: ").append(toIndentedString(resourceVersion)).append("\n");
    sb.append("    startOperatingDate: ").append(toIndentedString(startOperatingDate)).append("\n");
    sb.append("    activationFeature: ").append(toIndentedString(activationFeature)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceCharacteristic: ").append(toIndentedString(resourceCharacteristic)).append("\n");
    sb.append("    resourceRelationship: ").append(toIndentedString(resourceRelationship)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
    sb.append("    resourceStatus: ").append(toIndentedString(resourceStatus)).append("\n");
    sb.append("    usageState: ").append(toIndentedString(usageState)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

