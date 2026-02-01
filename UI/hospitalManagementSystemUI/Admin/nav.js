let menuItems = [
    {
        title: "Home",
        href: "index.html",
        icon: "home"
    },
    {
        title: "Patients",
        href: "patients.html",
        icon: "group"
    },
    {
        title: "Doctors",
        href: "doctors.html",
        icon: "people_outline"
    },
    {
        title: "Staffs",
        href: "staffs.html",
        icon: "wc"
    },
    {
        title: "Billings",
        href: "billings.html",
        icon: "folder_shared"
    },
    {
        title: "Rooms",
        href: "rooms.html",
        icon: "local_hotel"
    },
    {
        title: "Medical Procedures",
        href: "medical-procedures.html",
        icon: "assignment"
    }
];
const src =
    document.getElementById("nav-template").innerHTML;
const template = Handlebars.compile(src);
function updateMenuList() {
    const html = template({ menuItems });
    document
        .getElementById("nav-container").innerHTML = html;
}
updateMenuList();