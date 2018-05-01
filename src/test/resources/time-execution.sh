./time-command.sh "java -jar porter-stemmer-assembly-0.0.1.jar" baseline.log

BASELINE_AVERAGE=$(./calculate-average.sh baseline.log)
echo $BASELINE_AVERAGE
