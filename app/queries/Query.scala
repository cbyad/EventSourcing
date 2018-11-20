package queries

sealed trait Query

class History extends Query

class DistributionByConsumptionProductionByType extends Query