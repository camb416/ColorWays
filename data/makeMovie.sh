ffmpeg -r 60 -i screen-%04d.png -r 60 -c:v libx264  -pix_fmt yuv420p out3.mp4
