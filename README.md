InventoryApplication

Initial Configuration and Setup (Gradle build).

1. Install MySQL database with username: root, password:root and make sure it is up and running. 
    -> http://dev.mysql.com/downloads/windows/installer/5.7.html
2. Go to intelliJ -> file -> new -> project From version control -> git
3. For the git repository url use -> https://github.com/FTC-Utility/InventoryApplication.git
4. Give the parent directory destination of your project wherever you want it to be. 
5. Download apache tomcat 32 or 64 bit from the link , http://tomcat.apache.org/download-90.cgi
5. Extract the zip somewhere. 
7. Go to IntelliJ -> run -> Edit Configurations,
8. On the left click on the green plus sign and -> Tomcat server -> local. 
9. Give it a name and go to configure -> for the tomcat Home, browse and provide the root of tomcat folder the one you extracted.
10. On the run/debug configuration window go to deployment tab -> click on add -> select artifact -> select InventoryApplication.war or InventoryApplication.war (exploded)
12. (If you don't see any artifacts, go to file -> project Structure -> on the left pane select artifacts -> click on add (plus sign) -> hover on WebApplication:Archive or WebApplication:exploded -> from modules then select InventoryApplication.)
14. Make sure the port number is not occupied with another application and run it.
15. You should see a test page and test it by inserting data to the database.

Testing switch in commitcsdf