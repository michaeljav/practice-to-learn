document.getElementById('getDataButton').addEventListener('click', function() {
    // Write code to disable the button after button click,
    // fetch data from https://jsonplaceholder.typicode.com/users
    // and display the data in the table with id userData
    // Each user should have a row in the table
    // Each row should have 8 columns (id, username, name, email, phone, website, company name, address)
    // Each column should have the corresponding data from the fetched data
    // If there is an error, log the error in the console
    // append each row to a table body with id userData (example below)
    // <tbody id="userData">
    //     <tr>
    //         <td>1</td>
    //         <td>Leanne Graham</td>
    //         <td>Bret</td>
    //         <td>Sincere@april.biz</td>
    //         <td>1-770-736-8031 x56442</td>
    //         <td>hildegard.org</td>
    //         <td>Romaguera-Crona</td>
    //         <td>Gwenborough, Kulas Light, Apt. 556</td>
    //     </tr>
    //     <tr>
    //         More rows...
    //     </tr>
    // </tbody>

    const button = this;
    const tableBody = document.querySelector('#userData tbody');
    button.disabled = true;
    button.setAttribute('aria-busy', 'true');

    fetch('https://jsonplaceholder.typicode.com/users')
        .then(response => {
            if (!response.ok) throw new Error('Network error: ' + response.status);
            return response.json();
        })
        .then(users => {
            tableBody.innerHTML = '';
            users.forEach(user => {
                const tr = document.createElement('tr');
                const companyName = user.company?.name || '';
                const address = [user.address?.city, user.address?.street, user.address?.suite]
                    .filter(Boolean).join(', ');

                [user.id, user.username, user.name, user.email, user.phone, user.website, companyName, address]
                    .forEach(value => {
                        const td = document.createElement('td');
                        td.textContent = value;
                        tr.appendChild(td);
                    });
                tableBody.appendChild(tr);
            });
        })
        .catch(error => console.error('Error fetching data:', error))
        .finally(() => button.removeAttribute('aria-busy'));
});