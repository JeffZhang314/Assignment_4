public class Assignment_4 {
    public static void main(String [] args) {
        double [] [] ratings = {
            {6.351929690644446, 1.6760762720002365, 5.904438081300135, 9.23596266988633, 4.449510927801697, 2.4239264682706563, 4.132984161393184, 2.6756219923883062, 8.007473460116856, 8.169398663645204},
            {3.6104357255018305, 7.466084845380436, 4.064681592555224, 5.166158445688591, 7.698777588783664, 2.7640747013643576, 5.279454731557539, 0.18348559265068953, 4.008750910478746, 5.0174990968796385},
            {2.639002915999258, 5.526941830689651, 3.8540404304202323, 7.750010965662733, 0.6913402425879978, 6.463184721178017, 8.755071081139784, 8.551504770101253, 6.592706485452011, 6.973305016693315}
        };
        int movie = 1;
        int reviewer = 6;
        double powerMean = 0;
        println("Avg rating movie " + movie + " is " + movieAvgRating(ratings, movie, powerMean));
        println("Avg rating reviewer " + reviewer + " is " + reviewerAvgRating(ratings, reviewer, powerMean));
        println("Avg rating all ratings is " + avgRating2018(ratings, powerMean));
        println("Reviewer w/ lowest avg rating is " + hardestRater2018(ratings, powerMean));
        println("Movie w/ lowest avg rating is " + worstMovie2018(ratings, powerMean));
    }

    public static void print(String textPrinted) {
        System.out.print(textPrinted);
    }

    public static void print(double numPrinted) {
        System.out.print(numPrinted);
    }

    public static void println(String textPrinted) {
        System.out.println(textPrinted);
    }

    public static void println(double numPrinted) {
        System.out.println(numPrinted);
    }
    
    public static void println(double [] [] arrayPrinted) {
        System.out.println(arrayPrinted);
    }

    public static double movieAvgRating(double [] [] _ratings, int _movie, double _powerMean) {
        double [] cMovie = _ratings [_movie];
        int numRs = cMovie.length;
        if (_powerMean != 0) {
            double sumCMovie = 0;
            for (int r = 0; r < numRs; r ++) {
                sumCMovie += Math.pow(cMovie [r], _powerMean);
            }
            return Math.pow(sumCMovie/numRs, 1/_powerMean);
        } else {
            double sumCMovie = 1;
            for (int r = 0; r < numRs; r ++) {
                sumCMovie *= cMovie [r];
            }
            return Math.pow(sumCMovie, 1.0/numRs);
        }
    }

    public static double reviewerAvgRating(double [] [] _ratings, int _reviewer, double _powerMean) {
        int numCs = _ratings.length;
        if (_powerMean != 0) {
            double sumRReviewer = 0;
            for (int c = 0; c < numCs; c ++) {
                sumRReviewer += Math.pow(_ratings [c] [_reviewer], _powerMean);
            }
            return Math.pow(sumRReviewer/numCs, 1/_powerMean);
        } else {
            double sumRReviewer = 1;
            for (int c = 0; c < numCs; c ++) {
                sumRReviewer *= _ratings [c] [_reviewer];
            }
            return Math.pow(sumRReviewer, 1.0/numCs);
        }
    }

    public static double avgRating2018(double [] [] _ratings, double _powerMean) {
        int numCs = _ratings.length;
        int numRs = _ratings [0].length;
        if (_powerMean != 0) {
            double sumElementsRatings = 0;
            for (int c = 0; c < numCs; c ++) {
                for (int r = 0; r < numRs; r ++) {
                    sumElementsRatings += Math.pow(_ratings [c] [r], _powerMean);
                }
            }
            return Math.pow(sumElementsRatings/(numCs * numRs), 1/_powerMean);
        } else {
            double sumElementsRatings = 1;
            for (int c = 0; c < numCs; c ++) {
                for (int r = 0; r < numRs; r ++) {
                    sumElementsRatings *= _ratings [c] [r];
                }
            }
            return Math.pow(sumElementsRatings, 1.0/(numCs * numRs));
        }
    }

    public static int hardestRater2018(double [] [] _ratings, double _powerMean) {
        int rMinsSum = 0;
        double sumRMin = Double.MAX_VALUE;
        for (int r = 0; r < _ratings [0].length; r ++) {
            double sumElementsR;
            if (_powerMean != 0) {
                sumElementsR = 0;
                for (int c = 0; c < _ratings.length; c ++) {
                    sumElementsR += Math.pow(_ratings [c] [r], _powerMean);
                }
            } else {
                sumElementsR = 1;
                for (int c = 0; c < _ratings.length; c ++) {                    
                    sumElementsR *= _ratings [c] [r];
                }
            }
            if (sumElementsR < sumRMin) {
                sumRMin = sumElementsR;
                rMinsSum = r;
            }
        }
        return rMinsSum;
    }

    public static int worstMovie2018(double [] [] _ratings, double _powerMean) {
        int cMinsSum = 0;
        double sumCMin = Double.MAX_VALUE;
        for (int c = 0; c < _ratings.length; c ++) {
            double sumElementsC;
            if (_powerMean != 0) {
                sumElementsC = 0;
                for (int r = 0; r < _ratings [0].length; r ++) {
                    sumElementsC += Math.pow(_ratings [c] [r], _powerMean);
                }
            } else {
                sumElementsC = 1;
                for (int r = 0; r < _ratings [0].length; r ++) {
                    sumElementsC *= _ratings [c] [r];
                }
            }
            if (sumElementsC < sumCMin) {
                sumCMin = sumElementsC;
                cMinsSum = c;
            }
        }
        return cMinsSum;
    }
}