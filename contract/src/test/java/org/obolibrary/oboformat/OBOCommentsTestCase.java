package org.obolibrary.oboformat;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.semanticweb.owlapi.api.test.baseclasses.TestBase;
import org.semanticweb.owlapi.formats.OBODocumentFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;

@SuppressWarnings("javadoc")
public class OBOCommentsTestCase extends TestBase {

    @Test
    public void shouldAllowCommentInDate() {
        String in1 = "format-version: 1.2\n"
            + "data-version: beta2 ! WSIO Beta 2\n"
            + "date: 19:06:2014 18:57 ! CE(S)T";
        OWLOntology o1 = loadOntologyFromString(in1, IRI.create("urn:test1"),
            new OBODocumentFormat());
        String in2 = "format-version: 1.2\n"
            + "date: 19:06:2014 18:57 ! CE(S)T"
            + "data-version: beta2 ! WSIO Beta 2\n";
        OWLOntology o2 = loadOntologyFromString(in2, IRI.create("urn:test2"),
            new OBODocumentFormat());
        assertTrue(o1.equalAxioms(o2));
    }

    @Test
    public void shouldAllowInstanceStanza() {
        String in = "format-version: 1.2\n"
            + "date: 02:05:2014 08:22\n"
            + "saved-by: martinschiller\n"
            + "auto-generated-by: OBO-Edit 2.3-beta7\ndefault-namespace: HIV\nidspace: ROP http://purl.org/obo/owl/OBO_REL#\nidspace: ENVO http://purl.org/obo/owl/ENVO#\nidspace: snap http://www.ifomis.org/bfo/1.1/snap#\nidspace: VO http://purl.obolibrary.org/obo/VO\n"
            + "idspace: RO http://www.obofoundry.org/ro/ro.owl#\nidspace: MOD http://www.berkeleybop.org/ontologies/mod.owl\nidspace: BFO http://www.ifomis.org/bfo/1.1/\nidspace: MI http://psidev.cvs.sourceforge.net/viewvc/psidev/psi/mod/data/PSI-MOD.obo\nidspace: IDO http://purl.obolibrary.org/obo/ido.owl\nidspace: CHEBI http://purl.org/obo/owl/CHEBI#\nidspace: PRO http://purl.org/obo/owl/PRO#\nidspace: PATO http://purl.org/obo/owl/PATO#\n"
            + "idspace: birn_anat http://ontology.neuinfo.org/NIF/BiomaterialEntities/NIF-GrossAnatomy.owl#\nidspace: HPO http://purl.org/obo/owl/HP#\nidspace: UO http://purl.org/obo/owl/UO#\nidspace: NCBITaxon http://purl.org/obo/owl/NCBITaxon#\nidspace: OBI http://purl.obolibrary.org/obo/OBI_\nidspace: SO http://purl.org/obo/owl/SO#\nidspace: FMA http://purl.org/obo/owl/FMA#\nidspace: IAO http://purl.obolibrary.org/obo/IAO\nidspace: UBERON http://purl.org/obo/owl/UBERON#\nidspace: GO http://purl.org/obo/owl/GO#\nidspace: OGMS http://ogms.googlecode.com/svn/releases/2011-09-20/ontology/ogms.owl\nidspace: CL http://purl.org/obo/owl/CL#\nidspace: span http://www.ifomis.org/bfo/1.1/span#\nremark: This version 1.3 contains additional sources and minor corrections in the spacing of some ids for the HIV Ontology\nremark: This version 1.3 is of 2014-04-25\n\n"
            + "[Term]\nid: HIV:00000\nname: HIV\ndef: \"Human immunodeficiency virus (HIV) is a lentivirus that causes acquired immunodeficiency syndrome (AIDS), a condition in humans in which progressive failure of the immune system allows life-threatening opportunistic infections and cancers to thrive.\" [http://digitaljournal.com/article/363078]\nsynonym: \"HIV species\" RELATED [PMID:24743531]\nsynonym: \"Human Immunodeficiency Virus\" RELATED [PMID:24757518]\nxref: Source:NEWT\\:11676\nis_a: HIV:00029 ! retrovirus\nis_a: HIV:00043 ! lentivirus\n\n"
            + "[Term]\nid: HIV:00001\nname: HIV gene\ndef: \"A region (or regions) in the HIV genome that includes all of the sequence elements necessary to encode a functional transcript. A gene may include regulatory regions, transcribed regions and/or other functional sequence regions.\" [SO:0000704]\ncomment: A region of the HIV genome that encodes an RNA and/or protein. Definition adapted from SO:0000704.\nxref: Source:SO\\:0000704\nrelationship: part_of HIV:00029\nrelationship: part_of HIV:00038\n\n"
            + "[Term]\nid: HIV:00002\nname: HIV transcript\ndef: \"An RNA synthesized on a DNA or RNA template by an RNA polymerase.\" [SO:0000673]\ncomment: Definition adapted from SO:0000673.\nxref: Source:SO\\:0000673\nrelationship: part_of HIV:00029\nrelationship: is_transcribed_from HIV:00037\n\n"
            + "[Term]\nid: HIV:00003\nname: HIV protein\ndef: \"A linear polymer of amino acids joined by peptide bonds in a specific sequence encoded by the HIV genome.\" [MI:0326]\ncomment: Definition adapted from MI:03264.\nxref: Source:MI\\:0326\nrelationship: is_transcribed_and_translated_from HIV:00037\n\n"
            + "[Term]\nid: HIV:00004\nname: antiretroviral drug\ndef: \"A compound that inhibits the replication of retroviruses. Medications for the treatment of infection by retroviruses, primarily HIV.\" [http://www.sciencedaily.com/articles/a/antiretroviral_drug.htm]\n\n"
            + "[Term]\nid: HIV:00005\nname: FDA-approved antiretroviral drug\ndef: \"An antiretroviral drug that has been approved by the Food and Drug Administration (FDA).\" [http://medical-dictionary.thefreedictionary.com/Antiretroviral+drug]\nsynonym: \"FDA approved ARV drug\" RELATED [http://medical-dictionary.thefreedictionary.com/Antiretroviral+drug]\nrelationship: type_of HIV:00004\n\n"
            + "[Term]\nid: HIV:00006\nname: proteolytically processed protein\ndef: \"A HIV protein that is cleaved at one or more peptide bonds by a protease to create multiple proteins derived from the precursor.\" [PubMed:18688235]\nsynonym: \"processed\" RELATED [PMID:18830418]\nsynonym: \"proteolytic cleavage\" RELATED [PMID:24755218]\nxref: Source:GO\\:0006508\nxref: Source:MOD\\:00000\n\n"
            + "[Term]\nid: HIV:00007\nname: HIV protein domain\ndef: \"A HIV protein domain is a conserved part of a given HIV protein sequence and structure that can evolve, function, and exist independently of the rest of the protein chain. Each domain forms a compact three-dimensional structure and often can be independently stable and folded.\" [http://bioportal.bioontology.org/ontologies/NCIT?p=classes&conceptid=http%3A%2F%2Fncicb.nci.nih.gov%2Fxml%2Fowl%2FEVS%2FThesaurus.owl%23C13379]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00008\nname: HIV protein sequence motif\ndef: \"Signatures of protein families and can often be used as tools for the prediction of protein function.\" [PMID:8804823]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00009\nname: HIV minimotif\ndef: \"Minimotifs are short peptide sequences which play important roles in many cellular functions.\" [PMID:19656396]\nsynonym: \"HIV protein minimotif.\" RELATED [PMID:19656396]\nsynonym: \"HIV Short Linear Motif\" RELATED [PMID:19656396]\nsynonym: \"HIV SLiM\" RELATED [PMID:19656396]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00010\nname: HIV long terminal repeat\ndef: \"The long terminal repeat (LTR) of the human immunodeficiency virus (HIV) contains the viral promoter, which is responsible for viral gene expression in eukaryotic cells.\" [http://www.pnas.org/content/86/7/2157.full.pdf]\nsynonym: \"LTR\" RELATED [http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C13251]\nrelationship: part_of HIV:00038\n\n"
            + "[Term]\nid: HIV:00011\nname: HIV group\ndef: \"Scientists divide HIV types into groups. Each group is believed to represent an independent transmission of SIV into humans.\" [PMID:22229120]\nrelationship: type_of HIV:00000\n\n"
            + "[Term]\nid: HIV:00012\nname: HIV subtype\ndef: \"Group is subdivided further into subtypes that are designated with a letter.\" [PMID:7723052]\nsynonym: \"HIV clade\" RELATED [http://www.projecthalo.com/aura#Clade]\nrelationship: type_of HIV:00011\n\n"
            + "[Term]\nid: HIV:00013\nname: HIV circulating recombinant form\ndef: \"CRFs derived from recombination between viruses of different subtypes which are each given a number.\" [http://www.avert.org/hiv-types.htm]\nsynonym: \"CRF\" RELATED [http://www.avert.org/hiv-types.htm]\ncomment: CRF12_BF, for example, is a recombination between subtypes B and F.\n\n"
            + "[Term]\nid: HIV:00014\nname: HIV protein epitope\ndef: \"The simplest form of an antigenic determinant, on a complex antigenic molecule, which can combine with antibody or T cell receptor.\" [http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C13189]\nsynonym: \"antigenic determinant\" RELATED [http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C13189]\nsynonym: \"binding determinants\" RELATED [http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C13189]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00015\nname: HIV drug binding site\ndef: \"The reactive parts of an HIV macromolecule that directly participate in its specific combination with a drug.\" [http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C13405]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00016\nname: HIV posttranslational modification\ndef: \"The process of covalently altering one or more amino acids in a HIV protein after the protein has been completely translated and released from the ribosome.\" [GO:0043687]\nxref: GO:0043687\ncomment: Definition adapted from GO. [GO:0043687]\nsynonym: \"HIV post-translational modification\"[PMID:20170637]\nsynonym: \"HIV PTM\"[http://www.ncbi.nlm.nih.gov/pmc/articles/PMC3738961/]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00017\nname: host protein that interacts with an HIV protein\ndef: \"A human protein that binds to an HIV protein or covalently modifies a HIV protein.\" [PMID:18927109]\ncomment: Definition modified from PMID:18927109.\nxref: [http://www.ncbi.nlm.nih.gov/projects/RefSeq/HIVInteractions/tat.html\\][PMID\\:18927109\\]\n\n"
            + "[Term]\nid: HIV:00018\nname: host protein that interacts with an HIV RNA\ndef: \"A human protein that binds to an HIV RNA or covalently modifies a HIV RNA.\" [PMID:24554657]\n\n"
            + "[Term]\nid: HIV:00019\nname: host protein required for HIV replication\ndef: \"A class of human proteins that are essential for HIV replication, but are not lethal to the host cell when silenced.\" [PMID:21966263]\nsynonym: \"HDF\" RELATED [PMID:21966263]\nsynonym: \"HIV dependency factor\" RELATED [PMID:21966263]\n\n"
            + "[Term]\nid: HIV:00020\nname: HIV protein structure\ndef: \"The three-dimensional structure of an HIV protein, part of an HIV protein, or a complex of an HIV protein with another protein. The structure of a protein is characterized in four ways: The primary structure is the order of the different amino acids in a protein chain, whereas the secondary structure consists of the geometry of chain segments in forms such as helices or sheets. The tertiary structure describes how a protein folds in on itself; the quaternary structure of a protein describes how different protein chains hook up with each other.\" [http://dictionary.reference.com/browse/protein+structure]\ncomment: Definition adapted from website source.\nxref: FIX:0000327\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00021\nname: HIV protein structured region\ndef: \"Entire HIV proteins or regions that have a fixed tertiary structure.\" [PMID:24657436]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00022\nname: HIV unstructured protein\ndef: \"Entire HIV proteins or regions of HIV proteins that lack a fixed tertiary structure.\" [:pondr.com/pondr-tut1.html]\ncomment: Definition and synonyms adapted from sources indicated.\nsynonym: \"IDP\" RELATED [PMID:24656084]\nsynonym: \"Intrinsically disorded proteins\" RELATED [PMID:11381529]\nsynonym: \"Intrinsically unstructured proteins\" RELATED [PMID:15738986]\nsynonym: \"IUP\" RELATED [PMID:12368089]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00023\nname: HIV isolate\ndef: \"A specific individual microbe and its genetically identical progeny separated on a single occasion from a sample taken from a host or culture system.\" [http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C53471]\nsynonym: \"HIV strain\" RELATED [http://www.avert.org/hiv-types.htm]\nrelationship: type_of HIV:00000\n\n"
            + "[Term]\nid: HIV:00024\nname: HIV protein subcellular localization\ndef: \"Any process in which a HIV protein is transported to, and/or maintained in, a specific location at the level of a cell. Localization at the cellular level encompasses movement within the cell, from within the cell to the cell surface, or from one location to another at the surface of a cell.\" [GO:0034613]\ncomment: Definition adapted from GO:0034613.\nsynonym: \"cellular protein localisation \" RELATED [GO:0034613]\nsynonym: \"cellular protein localization \" RELATED [GO:0034613]\nsynonym: \"PSL\" RELATED [PMID:19958518]\n\n"
            + "[Term]\nid: HIV:00025\nname: HIV protein-protein interaction\ndef: \"Interactions between HIV and human proteins.\" [http://www.ncbi.nlm.nih.gov/projects/RefSeq/HIVInteractions/index.html, PMID:18927109]\ncomment: Database available at http://www.ncbi.nlm.nih.gov/projects/RefSeq/HIVInteractions/index.html. Definition adapted from PMID:18927109.\n\n"
            + "[Term]\nid: HIV:00026\nname: HIV protein-protein interaction residue\nsynonym: \"HIV protein-protein interaction amino acid\" RELATED [PMID:23867278]\ndef: \"Amino acids in HIV protein involved in the interactions between HIV and human proteins\" [PMID:23702796]\nrelationship: part_of HIV:00003\nrelationship: part_of HIV:00025\n\n"
            + "[Term]\nid: HIV:00027\nname: HIV protein sequence feature\ndef: \"Regions or sites of interest in the protein sequence. In general this section lists post-translational modifications, binding sites, enzyme active sites, local secondary structure or other characteristics.\" [http://www.uniprot.org/manual/sequence_annotation]\nrelationship: part_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00028\nname: HIV drug binding site residue\ndef: \"Drugs interact with HIV or host target proteins by bonding at specific binding sites. These binding sites are composed of amino acids that contact the drug which are called drug binding sites residues.\" [http://www.bio-toolkit.com/HIVTolbox/user_guide]\nsynonym: \"HIV drug binding site amino acid\" RELATED [http://www.merckmanuals.com/home/drugs/drug_dynamics/drug_action.html]\nrelationship: part_of HIV:00003\nrelationship: part_of HIV:00015\n\n"
            + "[Term]\nid: HIV:00029\nname: retrovirus\ndef: \"Retroviruses from the family Retroviridae are composed of numerous non-icosahedral, enveloped viruses which possess two copies of a single-stranded RNA genome that has a short dimerized region.\" [http://www.ncbi.nlm.nih.gov/retroviruses/]\nxref: Source:NEWT\\:31931\n\n"
            + "[Term]\nid: HIV:00030\nname: reverse transcription\ndef: \"A DNA synthesis process that uses RNA as the initial template for synthesis of DNA, but which also includes an RNase activity to remove the RNA strand of an RNA-DNA heteroduplex produced by the RNA-dependent synthesis step and use of the initial DNA strand as a template for DNA synthesis.\" [GO:0001171]\nxref: Source:GO\\:0001171\n\n"
            + "[Term]\nid: HIV:00031\nname: provirus integration\ndef: \"A process by which the virus integrates into the host genome and establishes as a stable provirus or prophage.\" [GO:0075713]\nxref: Source:GO\\:0075713\n\n"
            + "[Term]\nid: HIV:00032\nname: pre-integration complex\ndef: \"A nucleoprotein complex containing viral genetic material and associated viral and host proteins, which is capable of inserting a viral genome into a host genome.\" [GO:0019035]\nxref: Source:GO\\:0019035\n\n"
            + "[Term]\nid: HIV:00033\nname: viral budding\ndef: \"A viral process by which enveloped viruses acquire a host-derived membrane enriched in viral proteins to form their external envelope. The process starts when nucleocapsids, assembled or in the process of being built, induce formation of a membrane curvature in the host plasma or organelle membrane and wrap up in the forming bud. The process ends when the bud is eventually pinched off by membrane scission to release the enveloped particle into the lumenal or extracellular space.\" [GO:0046755]\nxref: Source:GO\\:0046755\n\n"
            + "[Term]\nid: HIV:00034\nname: viral assembly\ndef: \"A late phase of the viral life cycle during which all the components necessary for the formation of a mature virion collect at a particular site in the cell and the basic structure of the virus particle is formed.\" [GO:0019068]\nxref: Source:GO\\:0019068\n\n"
            + "[Term]\nid: HIV:00035\nname: viral envelope fusion\ndef: \"Fusion of a viral membrane with the host cell membrane during viral entry. Results in release of the virion contents into the cytoplasm.\" [GO:0019064]\nxref: Source:GO\\:0019064\n\n"
            + "[Term]\nid: HIV:00036\nname: viral maturation\ndef: \"The assembly of the component viral parts into an infectious virion.\" [GO:0019075]\nxref: Source:GO\\:0019075\n\n"
            + "[Term]\nid: HIV:00037\nname: genome\ndef: \"The entirety of an organism's hereditary information. It is encoded either in DNA or, for many types of viruses, in RNA. The genome includes both the genes and the non-coding sequences of the DNA/RNA.\" [PMID:_18258610]\n\n"
            + "[Term]\nid: HIV:00038\nname: HIV genome\ndef: \"The entirety of HIV's hereditary information. It is encoded either in DNA as a provirus, or as RNA in the vision and host cell. The genome includes both the genes and the non-coding sequences of the DNA/RNA.\" [http://www.yale.edu/bio243/HIV/genome.html]\nis_a: HIV:00037 ! genome\nrelationship: part_of HIV:00029\n\n"
            + "[Term]\nid: HIV:00039\nname: HIV RNA structure\ndef: \"HIV RNA structure is often divided into four different levels primary, secondary, tertiary and quaternary. Primary structure consists of a linear sequence of nucleotides that are linked together by phosphodiester bonds. It is this linear sequence of nucleotides that make up the primary structure of RNA. Secondary structure is the set of interactions between bases, i.e., parts of which is strands are bound to each other. Tertiary structure is the locations of the atoms in three-dimensional space, taking into consideration geometrical and steric constraints. The quaternary structure of nucleic acids is similar to that of protein quaternary structure. Although some of the concepts are not exactly the same, the quaternary structure refers to a higher-level of organization of RNA. Moreover, it refers to interactions of the nucleic acids with other molecules.\" [PMID:9430589]\nis_a: HIV:00037 ! genome\nis_a: HIV:00042 ! HIV RNA\n\n"
            + "[Term]\nid: HIV:00040\nname: HIV drug resistance mutation\ndef: \"Any mutation in the HIV genome that results in a change the susceptibility of HIV to one ore more antiretroviral drugs.\" [PMID:24746180]\nsynonym: \"DRM\" RELATED [http://www.bio-toolkit.com/GoMap/user_guide/]\n\n"
            + "[Term]\nid: HIV:00041\nname: HIV drug resistance mutation type\ndef: \"There are six DRM categories of HIV drug resistance mutations(DRMs): (1) A primary DRM causes resistance without any other mutations; (2) A primary set DRM has two or more mutations that cause resistance only in the presence of other primary set mutation(s); (3) A secondary set DRM enhances resistance caused by a primary mutation; (4) A beneficial DRM attenuates/prevents resistance by overriding another mutation that promotes resistance; (5); A beneficial set DRM has two or more mutations that each normally cause resistance, override each other and attenuate/prevent resistance (6) ; and (6) A resistance precursor DRM has no effect on resistance, but must occur prior to another primary or primary set of mutations.\" [http://www.bio-toolkit.com/GoMap/user_guide/]\nsynonym: \"DRM\" RELATED [http://www.bio-toolkit.com/GoMap/user_guide/]\nrelationship: type_of HIV:00040\n\n"
            + "[Term]\nid: HIV:00042\nname: HIV RNA\ndef: \"RNA that is transcribed from HIV proviral DNA.\" [PMID:24753416]\nrelationship: part_of HIV:00038\n\n"
            + "[Term]\nid: HIV:00043\nname: lentivirus\ndef: \"A genus of viruses of the Retroviridae family, characterized by a long incubation period.\" [PMID:24749361]\nis_a: HIV:00029 ! retrovirus\n\n"
            + "[Term]\nid: HIV:00044\nname: HIV RNA element\ndef: \"A RNA structure found in HIV RNA that plays a role in one or more steps of the replication cycle.\" [http://dx.doi.org/10.1016/j.chom.2013.01.007]\n\n"
            + "[Term]\nid: HIV:00045\nname: HIV structural protein\ndef: \"Protein products of gag, pol, and env genes which are essential components of the retroviral particle.\" [:LosAlamosHIVSequenceDatabaseCompendium2013]\nrelationship: type_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00046\nname: HIV regulatory protein\ndef: \"Tat and Rev proteins of HIV/SIV. They modulate transcriptional and posttranscriptional steps of virus gene expression and are essential for virus propagation.\" [:LosAlamosHIVSequenceDatabaseCompendium2013]\nrelationship: is_transcribed_and_translated_from HIV:00037\nrelationship: type_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00047\nname: HIV accessory protein\ndef: \"Additional virion and non-virion-associated proteins produced by HIV/SIV retroviruses: Vif, Vpr, Vpu, Vpx, Nef.  Although the accessory proteins are in general not necessary for viral propagation in tissue culture, they have been conserved in the different isolates; this conservation and experimental observations suggest that their role in vivo is very important. Their functional importance continues to be elucidated.\" [:LosAlamosHIVSequenceDatabaseCompendium2013]\nsynonym: \"HIV auxiliary protein\" RELATED [PMID:2202146]\nrelationship: is_transcribed_and_translated_from HIV:00037\nrelationship: type_of HIV:00003\n\n"
            + "[Term]\nid: HIV:00048\nname: HIV RNA dimerization\ndef: \"The retroviral genome consists of two identical RNA molecules joined at their 5' ends.\" [PMID:2124274, PMID:22328732]\nsynonym: \"HIV dimerization\" RELATED [PMID:2124274]\n\n"
            + "[Term]\nid: HIV:00049\nname: viral genome packaging\ndef: \"The encapsulation of the viral genome within the capsid.\" [GO:0019072]\nsynonym: \"encapsidation\" RELATED [PMID:24688060]\nsynonym: \"packaging\" RELATED [PMID:24530126]\nxref: GO:0019072\n\n"
            + "[Term]\nid: HIV:00050\nname: viral enzyme\ndef: \"Products of pol genes, which are essential components of the retroviral particle that catalyze different reactions.\" [:LosAlamosHIVSequenceDatabaseCompendium2013]\nrelationship: is_transcribed_and_translated_from HIV:00037\nrelationship: type_of HIV:00003\n\n"
            + "[Typedef]\nid: binds_to\nname: binds_to\nis_transitive: true\n\n"
            + "[Typedef]\nid: is_a\nname: is_a\n\n"
            + "[Typedef]\nid: is_transcribed_and_translated_from\nname: is_transcribed_and_translated_from\n\n"
            + "[Typedef]\nid: is_transcribed_from\nname: is_transcribed_from\n\n"
            + "[Typedef]\nid: is_translated_from\nname: is_translated_from\n\n"
            + "[Typedef]\nid: part_of\nname: part_of\nis_transitive: true\n\n"
            + "[Typedef]\nid: type_of\nname: type_of\n\n"
            + "[Typedef]\nid: RO:instance_of\nname: instance_of\nis_transitive: true\n\n"
            + "[Instance]\n"
            + "id: HIV:00101\n"
            + "name: HIV-1\n"
            + "synonym: \"HIV1\" RELATED []\n"
            + "synonym: \"HTLV-III\" RELATED []\n"
            + "synonym: \"Human Immunodeficiency Virus 1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus 1 HIV-1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus HIV-1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus type 1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus type 1 HIV 1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus type 1 HIV-1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus type 1 HIV1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus type 1, HIV-1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus type I HIV-1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus type-1 HIV-1\" RELATED []\n"
            + "synonym: \"human immunodeficiency virus-1 HIV-1\" RELATED []\n"
            + "synonym: \"LAV\" RELATED []\n" + "xref: NCBITaxon:11676\n"
            + "instance_of: HIV:00010\n"
            + "property value: host_range human\n" + "type_of: HIV:00000";
        loadOntologyFromString(in, IRI.create("urn:test"),
            new OBODocumentFormat());
    }
}
