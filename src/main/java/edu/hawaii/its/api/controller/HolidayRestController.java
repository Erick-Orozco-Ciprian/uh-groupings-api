package edu.hawaii.its.api.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.hawaii.its.api.service.HolidayService;
import edu.hawaii.its.api.type.Holiday;
import edu.hawaii.its.api.type.Type;

@RestController
public class HolidayRestController {

    private static final Log logger = LogFactory.getLog(HolidayRestController.class);

    @Autowired
    private HolidayService holidayService;

    @RequestMapping(value = "/api/holidays",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Holiday>>> holidays() {
        logger.info("Entered REST holidays...");
        JsonData<List<Holiday>> data = new JsonData<>(holidayService.findHolidays());
        return ResponseEntity
                .ok()
                .body(data);
    }

    @RequestMapping(value = "/api/holidays/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<Holiday>> holiday(@PathVariable Integer id) {
        logger.info("Entered REST holiday(" + id + ") ...");
        JsonData<Holiday> data = new JsonData<>(holidayService.findHoliday(id));
        return ResponseEntity
                .ok()
                .body(data);
    }

    @RequestMapping(value = "/api/types",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Type>>> types() {
        logger.info("Entered REST types...");
        List<Type> types = holidayService.findTypes();
        JsonData<List<Type>> data = new JsonData<>(types);
        return ResponseEntity
                .ok()
                .body(data);
    }

}
