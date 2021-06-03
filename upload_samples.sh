echo "Zipping Files"
zip -r $HOME/Downloads/samples-06-02-2021.zip $HOME/Downloads/synthea-output/

echo "uloading to s3"
aws s3 cp $HOME/Downloads/samples-06-02-2021.zip s3://synthea-sample-files/samples-06-02-2021.zip

echo "finished"