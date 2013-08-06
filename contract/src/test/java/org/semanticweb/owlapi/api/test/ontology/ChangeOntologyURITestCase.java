/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.semanticweb.owlapi.api.test.ontology;

import static org.junit.Assert.*;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.IRI;

import org.junit.Test;
import org.semanticweb.owlapi.api.test.baseclasses.AbstractOWLAPITestCase;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.OWLOntologyIRIChanger;

/** Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 25-May-2007<br>
 * <br> */
@SuppressWarnings("javadoc")
public class ChangeOntologyURITestCase extends AbstractOWLAPITestCase {
    @Test
    public void testChangeURI() throws OWLOntologyCreationException {
        OWLOntologyManager man = getManager();
        IRI oldIRI = IRI("http://www.semanticweb.org/ontologies/ontA");
        IRI newIRI = IRI("http://www.semanticweb.org/ontologies/ontB");
        OWLOntology ont = man.createOntology(oldIRI);
        OWLOntology importingOnt = man
                .createOntology(IRI("http://www.semanticweb.org/ontologies/ontC"));
        man.applyChange(new AddImport(importingOnt, man.getOWLDataFactory()
                .getOWLImportsDeclaration(ont.getOntologyID().getOntologyIRI())));
        assertTrue(man.contains(oldIRI));
        OWLOntologyIRIChanger changer = new OWLOntologyIRIChanger(man);
        man.applyChanges(changer.getChanges(ont, newIRI));
        assertFalse(man.contains(oldIRI));
        assertTrue(man.contains(newIRI));
        assertTrue(man.getOntologies().contains(ont));
        assertTrue(man.getDirectImports(importingOnt).contains(ont));
        assertNotNull("ontology should not be null", man.getOntology(newIRI));
        assertEquals(man.getOntology(newIRI), ont);
        assertEquals(man.getOntology(newIRI).getOntologyID().getOntologyIRI(), newIRI);
        assertTrue(man.getImportsClosure(importingOnt).contains(ont));
        assertNotNull("ontology should not be null", man.getOntologyDocumentIRI(ont));
        // Document IRI will still be the same (in this case the old ont URI)
        assertEquals(man.getOntologyDocumentIRI(ont), oldIRI);
        assertNotNull("ontology format should not be null", man.getOntologyFormat(ont));
    }

    @Test
    public void shouldCheckContents() throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        manager.createOntology(IRI.create("http://www.test.com/123"));
        OWLOntologyID anonymousId = OWLManager.createOWLOntologyManager()
                .createOntology().getOntologyID();
        manager.contains(anonymousId);
    }
}