# Gilded Rose Kata
A code exercise for refactoring legacy code

## Deploying the application
Deploy new versions of the application by adding a tag to the commit.  Follow the steps listed below to add a tag to a commit.  See [Git Tagging](https://git-scm.com/book/en/v2/Git-Basics-Tagging) for more information.
1. To tag the latest commit of your current branch, create an annotated tag with the following command:  git tag -a <tag_name> -m "message"
2. Name the tag with semantic versioning as follows:  v<major>.<minor>.<patch>
3. Push the tag to the remote repository with the following command: git push <tag_name>
4. Push multiple tags to the remote repository with the following command:  git push --tags


## Run Tests
1. [Install Java](https://java.com/en/download/help/download_options.html)
2. [Install JDK 15.0.2](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html)
3. Clone repository by typing the following in the terminal: git clone https://github.com/kudukacar/GildedRoseKata.git
4. In your terminal, navigate to the project folder
5. Type the following in the terminal to run the tests: ./gradlew test

## Running the Application
1. `./gradlew build` to update the .jar file with your changes
2. Find the updated file in GildedRoseKata/build/libs
3. `./gradlew bootRun` to run locally
4. Visit [localhost:8080](http://localhost:8080) to see the welcome page

## Access the Deployed App
1. Visit the app [here](http://gildedrosepairingproject-env.eba-hvgendhn.eu-west-1.elasticbeanstalk.com/)
