package io.swagger.api;

import io.swagger.model.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import io.swagger.model.ResourceCreate;
import io.swagger.model.ResourceCreateRequest;
import io.swagger.model.ResourceUpdate;

import io.swagger.configuration.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.configuration.ConfigProperties;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T01:38:50.932Z")

@Controller
public class ResourceApiController implements ResourceApi {
	@Autowired
	ConfigProperties configProp;
	String uniqueID = UUID.randomUUID().toString();

	private static final Logger log = LoggerFactory.getLogger(ResourceApiController.class);

	private static final int String = 0;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	// Adicionado para manejo de JPA

	@org.springframework.beans.factory.annotation.Autowired
	public ResourceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<String> createResource(
			@ApiParam(value = "The Resource to be created", required = true) @Valid @RequestBody ResourceCreate resource) {

		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {

				// FLUJO ALTA ACCESO OSP
				if (resource.getName().equals("ACCESS")) {
					System.out.println(resource.getResourceCharacteristic());

					// Crear encabezado
					HttpHeaders headers = new HttpHeaders();
					List<MediaType> list = new ArrayList<MediaType>();
					list.add(MediaType.APPLICATION_JSON);
					headers.setAccept(list);
					headers.setContentType(MediaType.APPLICATION_JSON);

					// Crear el body del request
					String body = "{\r\n" + "\"addressNormalized\"" + ":\""
							+ (resource.getResourceCharacteristic().get(0).getValueType()) + "\",\r\n"
							+ "\"locationID\"" + ":\"" + (resource.getResourceCharacteristic().get(1).getValueType())
							+ "\",\r\n" + "\"coordinateX\"" + ":\""
							+ (resource.getResourceCharacteristic().get(2).getValueType()) + "\",\r\n"
							+ "\"coordinateY\"" + ":\"" + (resource.getResourceCharacteristic().get(3).getValueType())
							+ "\",\r\n" + "\"resourceAccess\"" + ":\" "
							+ (resource.getResourceCharacteristic().get(5).getValueType()) + "\"\r\n}";

					System.out.println(body);

					HttpEntity<String> request1 = new HttpEntity<String>(body, headers);
					ResponseEntity<String> resultado = null;

					try {
						RestTemplate plantilla = new RestTemplate();
						resultado = plantilla.exchange(configProp.getConfigValue("endpointOSP"), HttpMethod.POST,
								request1, String.class);

						// System.out.println(request1);
						// System.out.println(plantilla);
						System.out.println(resultado);

						JsonElement root = new JsonParser().parse(resultado.getBody().toString());

						JsonElement AccessPoint = root.getAsJsonObject().get("allocateResourceResponse")
								.getAsJsonObject().get("rfslastmile").getAsJsonArray().get(0).getAsJsonObject()
								.get("ospCircuitID");
						JsonElement Code = root.getAsJsonObject().get("allocateResourceResponse").getAsJsonObject()
								.get("rfslastmile").getAsJsonArray().get(0).getAsJsonObject().get("workgroup");
						JsonElement Ip = root.getAsJsonObject().get("allocateResourceResponse").getAsJsonObject()
								.get("rfslastmile").getAsJsonArray().get(0).getAsJsonObject().get("workgroup");
						JsonElement Rack = root.getAsJsonObject().get("allocateResourceResponse").getAsJsonObject()
								.get("completeInformations").getAsJsonArray().get(0).getAsJsonObject()
								.get("relatedCircuits").getAsJsonObject().get("circuit").getAsJsonArray().get(0)
								.getAsJsonObject().get("resources").getAsJsonObject().get("relatedInicialResources")
								.getAsJsonArray().get(0).getAsJsonObject().get("initialResource").getAsJsonObject()
								.get("equipmentStructure").getAsJsonObject().get("rack");
						JsonElement SubRack = root.getAsJsonObject().get("allocateResourceResponse").getAsJsonObject()
								.get("completeInformations").getAsJsonArray().get(0).getAsJsonObject()
								.get("relatedCircuits").getAsJsonObject().get("circuit").getAsJsonArray().get(0)
								.getAsJsonObject().get("resources").getAsJsonObject().get("relatedInicialResources")
								.getAsJsonArray().get(0).getAsJsonObject().get("initialResource").getAsJsonObject()
								.get("equipmentStructure").getAsJsonObject().get("subRack");
						JsonElement Board = root.getAsJsonObject().get("allocateResourceResponse").getAsJsonObject()
								.get("completeInformations").getAsJsonArray().get(0).getAsJsonObject()
								.get("relatedCircuits").getAsJsonObject().get("circuit").getAsJsonArray().get(0)
								.getAsJsonObject().get("resources").getAsJsonObject().get("relatedInicialResources")
								.getAsJsonArray().get(0).getAsJsonObject().get("initialResource").getAsJsonObject()
								.get("equipmentStructure").getAsJsonObject().get("slot");
						JsonElement Port = root.getAsJsonObject().get("allocateResourceResponse").getAsJsonObject()
								.get("completeInformations").getAsJsonArray().get(0).getAsJsonObject()
								.get("relatedCircuits").getAsJsonObject().get("circuit").getAsJsonArray().get(0)
								.getAsJsonObject().get("resources").getAsJsonObject().get("relatedInicialResources")
								.getAsJsonArray().get(0).getAsJsonObject().get("initialResource").getAsJsonObject()
								.get("logicalUnit");

						try {

							// FLUJO ALTA ACCESO SIGRES

							HttpHeaders headersSigres = new HttpHeaders();
							List<MediaType> listSigres = new ArrayList<MediaType>();
							list.add(MediaType.APPLICATION_JSON);
							headersSigres.setAccept(listSigres);

							headersSigres.setContentType(MediaType.APPLICATION_JSON);

							// Crear el body del request
							String bodySigres =
									// (resource.getResourceCharacteristic().get(5).getValueType())

									"{\r\n" + "\"accessID\"" + ": \""
											+ (resource.getResourceCharacteristic().get(5).getValueType()) + "\",\r\n"
											+ "\"accessProfile\"" + ": \""
											+ (resource.getResourceCharacteristic().get(5).getValueType()) + "\",\r\n"
											+ "\"terminalNumber\"" + ": " + Code + ",\r\n" + "\"accessPoint\"" + ": "
											+ AccessPoint + ",\r\n" + "\"code\"" + ": " + Code + ",\r\n" + "\"ip\""
											+ ": " + Code + ",\r\n" + "\"rack\"" + ": " + Rack + ",\r\n" + "\"subRack\""
											+ ": " + SubRack + ",\r\n" + "\"board\"" + ": " + Board + ",\r\n"
											+ "\"port\"" + ": \"" + Port + "\"\r\n}";

							System.out.println(bodySigres);

							HttpEntity<String> requestSigres = new HttpEntity<String>(bodySigres, headersSigres);
							ResponseEntity<String> resultadoSigres = null;

							try {
								RestTemplate plantillaSigres = new RestTemplate();
								resultado = plantillaSigres.exchange(configProp.getConfigValue("endpointSigres"),
										HttpMethod.POST, requestSigres, String.class);
								System.out.println(resultadoSigres);

								return new ResponseEntity<String>("{\"ACK\":\"Refused\"}", HttpStatus.BAD_GATEWAY);
							} finally {
							}
						} finally {
						}
					} finally {
					}
				}

			}

			catch (Exception e) {
			}
			return new ResponseEntity<String>("{\"ACK\":\"Accept\"}", HttpStatus.ACCEPTED);
		
	}
			
			//Valida tipo de servicio aprovisionar en SIGRES Envia alta de Banda Ancha
			
				try {
					String uniqueID = UUID.randomUUID().toString();
					//System.out.println(uniqueID);
					if (resource.getName().equals("BB")) {
						// Crear encabezado
						HttpHeaders headers = new HttpHeaders();
						List<MediaType> list = new ArrayList<MediaType>();
						list.add(MediaType.APPLICATION_JSON);
						headers.setAccept(list);
						headers.setContentType(MediaType.APPLICATION_JSON);
						String oldString1 = resource.getResourceCharacteristic().get(5).getValueType();
						String newString1 = oldString1.replace("CAI_", "RBP_");

						// Crear el body del request
						String body = "{\r\n" + "\"SigresService\":{\r\n\"Interface\"" + ":\"Interface=INT.SIGRES.FS.101" + ""
								+ "\",\r\n" + "\"Destination\"" + ":\"INVENTARIO" + "" + "\",\r\n" + "\"Process\""
								+ ":\"string\"," + "" + " " + "\r\n" + "\"Version\"" + ":\"1.0" + "" + "\",\r\n" + "\"Source\""
								+ ":\"ISAPACK" + "" + "\",\r\n" + "\"Domain\"" + ":\"CO" + "" + "\",\r\n" + "\"Other\""
								+ ":{\r\n" + "" + "\"value\"" + " :{\r\n\"" + "name\"" + ":\"execId" + "" + "\",\r\n"
								+ "\"text\":\"" + uniqueID + "" + "\"\r\n" + "} " + "\r\n" + "} "
								+ "\r\n" + "}" + ",\r\n\"" + "Inventory\"" + ":" + " {\r\n" + "\"CreateCFSBB\"" + ":" + "{\r\n"
								+ "\"InputParameters\"" + ":" + "{\r\n" + "\"Ids\"" + ":" + " {\r\n" + "\"AccessID\"" + ":\""
								+ resource.getResourceCharacteristic().get(5).getValueType() + "" + "\",\r\n" + "\"SiidCFS\"" + ":\""
								+ resource.getResourceCharacteristic().get(5).getValueType() + "\",\r\n" + "\"SiidRFS\"" + ":\"" + newString1 + "\"" + "\r\n"
								+ "} \r\n" + "} \r\n" + "} \r\n" + "} \r\n" + "} \r\n";

						System.out.println(body);
						HttpEntity<String> request1 = new HttpEntity<String>(body, headers);
						ResponseEntity<String> resultado = null;
						try {
							RestTemplate plantilla = new RestTemplate();
							resultado = plantilla.exchange(configProp.getConfigValue("endpointTLFSIGRES"), HttpMethod.POST, request1,
									String.class);
						} catch (Exception e) {
							System.out.println(e);
							return new ResponseEntity<String>("{\"ACK\":\"Refused\"}", HttpStatus.BAD_GATEWAY);
						}
					}
					
					// Envia alta de voz ip 

					else if (resource.getName().equals("VOIP")) {

						// Crear encabezado
						HttpHeaders headers = new HttpHeaders();
						List<MediaType> list = new ArrayList<MediaType>();
						list.add(MediaType.APPLICATION_JSON);
						headers.setAccept(list);
						headers.setContentType(MediaType.APPLICATION_JSON);
						String oldString3 = resource.getResourceCharacteristic().get(5).getValueType();
						String newString2 = oldString3.replace("CAI_", "RVP_");

						// Crear el body del request
						String body = "{\r\n" + "\"SigresService\":{\r\n\"Interface\"" + ":\"Interface=INT.SIGRES.FS.101" + ""
								+ "\",\r\n" + "\"Destination\"" + ":\"INVENTARIO" + "" + "\",\r\n" + "\"Process\""
								+ ":\"string\"," + "" + " " + "\r\n" + "\"Version\"" + ":\"1.0" + "" + "\",\r\n" + "\"Source\""
								+ ":\"ISAPACK" + "" + "\",\r\n" + "\"Domain\"" + ":\"CO" + "" + "\",\r\n" + "\"Other\""
								+ ":{\r\n" + "" + "\"value\"" + " :{\r\n\"" + "name\"" + ":\"execId" + "" + "\",\r\n"
								+ "\"text\":\"" + uniqueID + "\"\r\n" +  "} " + "\r\n" + "} "
								+ "\r\n" + "}" + ",\r\n\"" + "Inventory\"" + ":" + " {\r\n" + "\"CreateCFSVoice\"" + ":"
								+ "{\r\n" + "\"InputParameters\"" + ":" + "{\r\n" + "\"Ids\"" + ":" + " {\r\n" + "\"AccessID\""
								+ ":\"" + oldString3 + "" + "\",\r\n" + "\"SiidCFS\"" + ":\""
								+ oldString3 + "\",\r\n" + "\"SiidRFS\"" + ":\"" + newString2 + "\"" + "\r\n"
								+ "}, \r\n" + "\"SubtypeOperation\"" + ":\"false\"" + "\r\n" + "} \r\n" + "} \r\n" + "} \r\n"
								+ "} \r\n";

						System.out.println(body);
						HttpEntity<String> request1 = new HttpEntity<String>(body, headers);
						ResponseEntity<String> resultado = null;
						try {
							RestTemplate plantilla = new RestTemplate();
							resultado = plantilla.exchange(configProp.getConfigValue("endpointTLFSIGRES"), HttpMethod.POST, request1,
									String.class);
						} catch (Exception e) {
							System.out.println(e);
							return new ResponseEntity<String>("{\"ACK\":\"Refused\"}", HttpStatus.BAD_GATEWAY);
						}
					}
					// Envia alta de IPTV
					else if (resource.getName().equals("IPTV")) {

						// Crear encabezado
						HttpHeaders headers = new HttpHeaders();
						List<MediaType> list = new ArrayList<MediaType>();
						list.add(MediaType.APPLICATION_JSON);
						headers.setAccept(list);
						headers.setContentType(MediaType.APPLICATION_JSON);
						String oldString3 = resource.getResourceCharacteristic().get(5).getValueType();
						String newString3 = oldString3.replace("CAI_", "RIP_");
						String newString4 = oldString3.replace("CAI_", "RIS_");

						// Crear el body del request
						String body = "{\r\n" + "\"SigresService\":{\r\n\"Interface\"" + ":\"Interface=INT.SIGRES.FS.103" + ""
								+ "\",\r\n" + "\"Destination\"" + ":\"INVENTARIO" + "" + "\",\r\n" + "\"Process\""
								+ ":\"string\"," + "" + " " + "\r\n" + "\"Version\"" + ":\"1" + "" + "\",\r\n" + "\"Source\""
								+ ":\"ISAPACK" + "" + "\",\r\n" + "\"Domain\"" + ":\"CO" + "" + "\",\r\n" + "\"Other\""
								+ ":{\r\n" + "" + "\"value\"" + " :{\r\n\"" + "name\"" + ":\"execId" + "" + "\",\r\n"
								+ "\"text\":\"" + uniqueID + "" + "\"\r\n" +  "" + "\"\r\n" + "} " + "\r\n" + "} "
								+ "\r\n" + "}" + ",\r\n\"" + "Inventory\"" + ":" + " {\r\n" + "\"CreateCFSIPTV\"" + ":"
								+ "{\r\n" + "\"InputParameters\"" + ":" + "{\r\n" + "\"Ids\"" + ":" + " {\r\n" + "\"AccessID\""
								+ ":\"" + oldString3 + "" + "\",\r\n" + "\"SiidCFS\"" + ":\""
								+ oldString3 + "\",\r\n" + "\"SiidRFSRIP\"" + ":\"" + newString3 + "\","
								+ "\r\n" + "\"SiidRFSRIS\"" + ":\"" + newString4 + "\"" + "\r\n" + "}, \r\n"
								+ "\"SubtypeOperation\"" + ":\"false\"" + "\r\n" + "} \r\n" + "} \r\n" + "} \r\n" + "} \r\n";

						System.out.println(body);
						HttpEntity<String> request1 = new HttpEntity<String>(body, headers);
						ResponseEntity<String> resultado = null;
						try {
							RestTemplate plantilla = new RestTemplate();
							resultado = plantilla.exchange(configProp.getConfigValue("endpointTLFSIGRES"), HttpMethod.POST, request1,
									String.class);
						} catch (Exception e) {
							System.out.println(e);
							return new ResponseEntity<String>("{\"ACK\":\"Refused\"}", HttpStatus.BAD_GATEWAY);
						}
					}

				}

				catch (Exception e) {
				}
				return new ResponseEntity<String>("{\"ACK\":\"Accept\"}", HttpStatus.ACCEPTED);
			}

		
	public ResponseEntity<Void> deleteResource(
			@ApiParam(value = "Identifier of the Resource", required = true) @PathVariable("id") String id) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Resource>> listResource(
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Resource>>(objectMapper.readValue("{}", List.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Resource>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Resource>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Resource> patchResource(
			@ApiParam(value = "Identifier of the Resource", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The Resource to be updated", required = true) @Valid @RequestBody ResourceUpdate resource) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Resource>(objectMapper.readValue("{}", Resource.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Resource>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Resource> retrieveResource(
			@ApiParam(value = "Identifier of the Resource", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Resource>(objectMapper.readValue("{}", Resource.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Resource>(HttpStatus.NOT_IMPLEMENTED);
	}

}
