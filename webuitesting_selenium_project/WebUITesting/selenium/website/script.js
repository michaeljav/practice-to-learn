document.getElementById('getDataButton').addEventListener('click', function () {
  // Disable the button and mark it busy
  const button = this;
  const tableBody = document.querySelector('#userData tbody');
  button.disabled = true;
  button.setAttribute('aria-busy', 'true');

  // Fetch data from the public placeholder API
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

        [
          user.id,
          user.username,
          user.name,
          user.email,
          user.phone,
          user.website,
          companyName,
          address
        ].forEach(value => {
          const td = document.createElement('td');
          td.textContent = value;
          tr.appendChild(td);
        });

        tableBody.appendChild(tr);
      });
    })
    .catch(err => console.error('Error fetching data:', err))
    .finally(() => {
      // Keep disabled after first click, as per test expectations
      button.removeAttribute('aria-busy');
    });
});
