const visibilityToggle = document.querySelector('.visibility');
const input = document.querySelector('#password');

var password = true;

visibilityToggle.addEventListener('click', function () {
  if (password) {
    input.setAttribute('type', 'text');
    visibilityToggle.innerHTML = 'visibility';
  } else {
    input.setAttribute('type', 'password');
    visibilityToggle.innerHTML = 'visibility_off';
  }
  password = !password;
});