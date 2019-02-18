package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {

    private VetController controller;
    private VetService vetService;

    @BeforeEach
    void setUp() {

        this.vetService = new VetMapService(new SpecialityMapService());
        this.controller = new VetController(vetService);
    }

    @Test
    void listVets() {

        this.vetService.save(new Vet(1l,"First","last", new HashSet<>()));
        this.vetService.save(new Vet(2l,"First","last", new HashSet<>()));
        Model model = new ModelMapImpl();
        assertEquals("vets/index", this.controller.listVets(model));
        Map<String, Object> modelData = ((ModelMapImpl) model).getModelData();
        assertThat(modelData).containsKey("vets");
        assertThat((Set<Vet>)modelData.get("vets")).hasSize(2);
    }

}