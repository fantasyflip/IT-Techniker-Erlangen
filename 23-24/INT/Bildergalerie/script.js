function generateImageElements(amount) {
  let document = window.document;
  let galleryParent = document.getElementById("gallery-wrapper");
  for (let i = 0; i < amount; i++) {
    let image = document.createElement("img");

    fetch(`https://source.unsplash.com/user/fantasyflip`).then((response) => {
      image.src = response.url;
      image.alt =
        "Random image from unsplash by user Philipp Katzenberger - " + i;
      image.classList.add("gallery-item");

      galleryParent.appendChild(image);
    });
  }
}

window.addEventListener("load", function () {
  generateImageElements(15);
});

window.addEventListener("scroll", function () {
  if (window.innerHeight + window.scrollY >= document.body.offsetHeight - 200) {
    generateImageElements(10);
  }
});
