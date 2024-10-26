plugins {
    id("java")
}

group = "com.joaquinonsoft.concatpdf"
version = "2024.10.26"

repositories {
    mavenCentral()
}

dependencies {
    // Apache Commons CLI provides a simple API for presenting, processing and validating a Command Line Interface.
    // https://mvnrepository.com/artifact/commons-cli/commons-cli
    implementation("commons-cli:commons-cli:1.9.0")


    // Apache PDFBox » 3.0.3
    // The Apache PDFBox library is an open source Java tool for working with PDF documents.
    // https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox
    implementation("org.apache.pdfbox:pdfbox:3.0.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}