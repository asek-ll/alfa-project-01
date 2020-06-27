/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.alfabattle.contest.project;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ru.alfabattle.contest.project.view.BranchView;
import ru.alfabattle.contest.project.view.BranchWithDistanceView;
import ru.alfabattle.contest.project.view.PredictionView;
import ru.alfabattle.contest.project.view.StatusView;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ApplicationConfigurationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void branchesCanBeFetchet() throws Exception {
        ResponseEntity<BranchView> entity = restTemplate
                .getForEntity("http://localhost:" + this.port + "/branches/612", BranchView.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        BranchView branch = entity.getBody();
        assertEquals(612, (long) branch.getId());
    }

    @Test
    public void whenBranchNotFoundShouldReturn404() throws Exception {
        ResponseEntity<StatusView> entity = restTemplate
                .getForEntity("http://localhost:" + this.port + "/branches/1", StatusView.class);

        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
        assertEquals("branch not found", entity.getBody().getStatus());
    }

    @Test
    public void closesBranchesCanBeFoundedByLatLon() throws Exception {
        ResponseEntity<BranchWithDistanceView> entity = restTemplate
                .getForEntity("http://localhost:" + this.port + "/branches/?lat=55.773284&lon=37.624125", BranchWithDistanceView.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(430, (long) entity.getBody().getDistance());
    }

    @Test
    public void branchCustomerWaitCanBePredicted() throws Exception {
        ResponseEntity<PredictionView> entity = restTemplate
                .getForEntity("http://localhost:" + this.port + "/branches/612/predict?dayOfWeek=1&hourOfDay=14", PredictionView.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        PredictionView predictionView = entity.getBody();
        assertEquals(1, predictionView.getDayOfWeek());
        assertEquals(14, predictionView.getHourOfDay());
        assertEquals(117L, predictionView.getPredicting());
    }

}
