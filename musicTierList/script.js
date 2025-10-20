async function loadSongs(){
    try{
       const response = await fetch(
  'songs.json',
  { cache: 'no-store' }
);


        const data = await response.json();
        data.songs.forEach(song => {
            const img = document.createElement('img');
            img.src = song.imageLink;
            img.alt = song.title;
            img.title = song.title;
            img.classList.add('song-image');

            const tierDiv = document.querySelector(`#${song.tier} .tierSort`);

            if(tierDiv){
                tierDiv.appendChild(img);
            } else{
                console.warn(`Tier ${song.tier} not found for song: ${song.title}`);
            }
        });
    } catch(err){
        console.error(err);
    }
}

loadSongs();



