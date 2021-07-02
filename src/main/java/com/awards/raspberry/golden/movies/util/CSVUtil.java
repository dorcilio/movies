package com.awards.raspberry.golden.movies.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.awards.raspberry.golden.movies.model.Movie;

public class CSVUtil {
	public static String TYPE = "text/csv";

	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Movie> parseCSVToMovie(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
			             CSVFormat.newFormat(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Movie> movies = new ArrayList<Movie>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				Movie movie = new Movie();
				movie.setYear(Integer.parseInt(csvRecord.get(0)));
				movie.setTitle(csvRecord.get(1).trim());
				movie.setStudio(csvRecord.get(2).trim());
				movie.setProducer(csvRecord.get(3).trim());
				movie.setWinner(csvRecord.get(4).isEmpty() ? false : csvRecord.get(4).trim().equals("yes"));
				movies.add(movie);
			}
			return movies;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}
