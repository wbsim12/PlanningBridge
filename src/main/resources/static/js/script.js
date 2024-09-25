// scripts.js
function toggleSidebar() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.classList.toggle('collapsed');

    // 전환이 완료된 후 서브메뉴 상태 조정
    setTimeout(() => {
        const activeItems = sidebar.querySelectorAll('.menu-item.active');
        activeItems.forEach(item => {
            if (sidebar.classList.contains('collapsed')) {
                item.classList.remove('active');
            }
        });
    }, 300);
}

function toggleSubMenu(event) {
    event.preventDefault();
    const menuItem = event.currentTarget.parentElement;
    menuItem.classList.toggle('active');
}

function toggleDropdown(event) {
    event.preventDefault();
    const dropdown = event.currentTarget.nextElementSibling;
    dropdown.classList.toggle('show');
}

document.addEventListener('click', function(event) {
    if (!event.target.matches('.dropdown-toggle')) {
        const dropdowns = document.querySelectorAll('.dropdown-menu');
        dropdowns.forEach(dropdown => {
            if (dropdown.classList.contains('show')) {
                dropdown.classList.remove('show');
            }
        });
    }
});
