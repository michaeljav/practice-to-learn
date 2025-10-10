# Web UI Testing Project (HTML, CSS, JavaScript)

## Instructions (as given in the test)

You are provided with a project in which you are expected to complete only **HTML**, **CSS**, and **JavaScript** in the files located in the `Website` folder.

The project `Website` runs on the Jetty server on port 8080 and uses **Java-Selenium** in headless mode with **Spring Boot** on port 8000 to test the UI and functionality.

### Tasks

1. Modify the title of the `index.html` file to `User Data`.
2. Insert an anchor tag in the `index.html` file, allowing navigation from the `index.html` page to the `responsive.html` page using a designated ID attribute.
3. Complete the code in the `script.js` file to fetch data from the API located at `https://jsonplaceholder.typicode.com/users` and display the specified fields, as outlined in the provided file. This must be executed when clicking a button with the id `getDataButton`.
4. Complete the code in the `styles.css` file to hide all columns except for **id**, **username**, and **name** when the screen is 768px wide or less.
5. Disable the `#getDataButton` button once clicked and enable it only on reloading the page; Apply the colours and cursor style specified in the `styles.css` file.

### Testing Instructions

1. The project is hosted on `https://he-ide.hackerearth.com/<generated-hash>/`.  
2. Upon clicking the **Run code** or **Submit code** buttons, access the **Build log** or **Execution log** to review comprehensive details about the test outcomes.

### Submission Instructions

1. Clicking **Run code** compiles and runs your code against sample tests but does not assign scores.  
2. Clicking **Submit code** runs your code against multiple test cases and assigns the final score.

### Notes

- Do not modify any other file in the project, or the solution may be invalid.  
- In some cases, due to network latency, the development environment may take time to load. Check the “logs” section to monitor activity.

---

## 💻 Run Locally

### 1️⃣ Download or clone this project

You can download the ZIP or run:

```bash
git clone <this_project_url>
cd WebUITestingProject
```

### 2️⃣ Open the `website` folder

Inside, you’ll find these files:

```
website/
 ├── index.html
 ├── responsive.html
 ├── script.js
 └── styles.css
```

### 3️⃣ Run locally

Just open the **index.html** file in your browser (double-click it or right-click → *Open With → Browser*).  
No backend setup is required.

---

✅ **Done!**  
You can now click **“Get User Data”** to fetch the users from the public API and test the responsive table behaviour.
