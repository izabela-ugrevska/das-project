#!/bin/bash
osmfilter macedonia-latest.osm --keep= --keep-nodes=name -o=withNames.osm
osmfilter withNames.osm --keep="wheelchair=yes" | osmconvert - --all-to-nodes --csv="@id @lon @lat name" --csv-headline --csv-separator="," -o="filtered.csv"
